package com.ljw.servlet;

import com.ljw.bean.Article;
import com.ljw.bean.Follow;
import com.ljw.bean.User;
import com.ljw.service.ArticleService;
import com.ljw.service.CollectService;
import com.ljw.service.FollowService;
import com.ljw.service.UserService;
import com.ljw.service.impl.ArticleServiceImpl;
import com.ljw.service.impl.CollectServiceImpl;
import com.ljw.service.impl.FollowServiceImpl;
import com.ljw.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/article/*")
public class ArticleServlet extends HttpServlet {
    private ArticleService articleService = new ArticleServiceImpl();
    private CollectService collectService = new CollectServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("delete article id = "+id);
        collectService.deleteById(id);
        articleService.deleteArticle(new Article(id, null, null, null, null));
        response.getWriter().write("1");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        String path = request.getPathInfo();
        System.out.println(path);
        if (path == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        if (path.equals("/alterArticle")) {
            alterArticle(request, response);
        } else if (path.equals("/addArticle")) {
            addArticle(request, response);
        } else {
            // 如果路径不匹配，返回错误响应
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    protected void addArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        System.out.println(id);
        System.out.println(title);
        System.out.println(content);
        articleService.uploadArticle(new Article(null, title, content, null, id));
        response.getWriter().write("1");
    }

    protected void alterArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        System.out.println(title);
        System.out.println(content);
        articleService.alterArticle(new Article(id, title, content, null, null));
        response.getWriter().write("1");
    }
}
