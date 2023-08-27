package com.ljw.servlet;

import com.google.gson.Gson;
import com.ljw.bean.Article;
import com.ljw.bean.User;
import com.ljw.service.ArticleService;
import com.ljw.service.UserService;
import com.ljw.service.impl.ArticleServiceImpl;
import com.ljw.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/main/*")
public class MainServlet extends HttpServlet {
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
        if (path.equals("/queryAll")) {
            queryAll(request, response);
        } else if (path.equals("/queryArticleById")) {
            queryArticleById(request, response);
        } else if (path.equals("/queryArticleByAuthor_id")) {
            queryArticleByAuthor_id(request, response);
        } else if (path.equals("/querySearch")) {
            querySearch(request, response);
        } else {
            // 如果路径不匹配，返回错误响应
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }


    protected void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Article> articles = new ArrayList<Article>();
        for (Article tmp : articleService.queryArticles()) {
            tmp.setContent(userService.queryUsernameById(tmp.getAuthor_id()));
            articles.add(tmp);
        }
        // 将数据转换为JSON格式
        Gson gson = new Gson();
        String json = gson.toJson(articles);
        // 设置响应头和响应数据
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }

    protected void queryArticleById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Article article = articleService.queryArticleById(id);
        // 将数据转换为JSON格式
        Gson gson = new Gson();
        String json = gson.toJson(article);
        // 设置响应头和响应数据
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    protected void queryArticleByAuthor_id(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        List<Article> articles = new ArrayList<Article>();
        for (Article tmp : articleService.queryArticlesByAuthor_id(id)) {
            tmp.setContent(userService.queryUsernameById(tmp.getAuthor_id()));
            articles.add(tmp);
        }
        // 将数据转换为JSON格式
        Gson gson = new Gson();
        String json = gson.toJson(articles);
        // 设置响应头和响应数据
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    protected void querySearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = new String(request.getParameter("str").getBytes("ISO-8859-1"), "UTF-8");
        //request.setCharacterEncoding("UTF-8");
        //String str = request.getParameter("str");request.setCharacterEncoding("UTF-8");
        System.out.println(str);
        List<Article> articles = new ArrayList<Article>();
        for (Article tmp : articleService.querySearch(str)) {
            tmp.setContent(userService.queryUsernameById(tmp.getAuthor_id()));
            articles.add(tmp);
        }
        for (User tmp : userService.querySearch(str)) {
            articles.add(new Article(null, null, tmp.getUsername(), null, null));
        }
        for (Article tmp : articles) {
            System.out.println(tmp.toString());
        }

        // 将数据转换为JSON格式
        Gson gson = new Gson();
        String json = gson.toJson(articles);
        // 设置响应头和响应数据
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}
