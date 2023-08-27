package com.ljw.servlet;

import com.google.gson.Gson;
import com.ljw.bean.Article;
import com.ljw.bean.Collect;
import com.ljw.bean.User;
import com.ljw.service.ArticleService;
import com.ljw.service.CollectService;
import com.ljw.service.UserService;
import com.ljw.service.impl.ArticleServiceImpl;
import com.ljw.service.impl.CollectServiceImpl;
import com.ljw.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/collect/*")
public class CollectServlet extends HttpServlet {
    private CollectService collectService = new CollectServiceImpl();
    private ArticleService articleService = new ArticleServiceImpl();
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        System.out.println(path);

        if (path == null) {
            // 如果路径为空，返回错误响应
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        if (path.equals("/queryAllById")) {
            queryAllById(request, response);
        } else if (path.equals("/deleteCollectById")) {
            deleteCollectById(request, response);
        } else if (path.equals("/addCollect")) {
            addCollect(request, response);
        } else {
            // 如果路径不匹配，返回错误响应
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }


    protected void queryAllById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("queryAllById");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getId();
        System.out.println(id);

        List<Article> articles = new ArrayList<Article>();
        for (Collect tmp : collectService.queryAllById(id)) {
            Article article = articleService.queryArticleById(tmp.getArticle_id());
            article.setContent(userService.queryUsernameById(article.getAuthor_id()));
            articles.add(article);
        }

        // 将数据转换为JSON格式
        Gson gson = new Gson();
        String json = gson.toJson(articles);
        // 设置响应头和响应数据
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    protected void deleteCollectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deleteCollectById");
        int followId = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getId();
        collectService.deleteCollect(new Collect(null, id, followId));
        response.getWriter().write("1");
    }

    protected void addCollect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("addCollect");
        int followId = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getId();
        int collectId = Integer.parseInt(request.getParameter("id"));
        System.out.println(id + "+" + collectId);
        if (!collectService.isCollect(new Collect(null, id, collectId))) {
            collectService.addCollect(new Collect(null, id, collectId));
            response.getWriter().write("1");
        } else {
            response.getWriter().write("2");
        }
    }
}