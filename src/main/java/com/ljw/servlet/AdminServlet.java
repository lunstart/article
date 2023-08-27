package com.ljw.servlet;

import com.google.gson.Gson;
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

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private ArticleService articleService = new ArticleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = new ArrayList<User>();
        for (User tmp : userService.queryAll()) {
            int count = articleService.queryArticlesByAuthor_id(tmp.getId()).size();
            tmp.setPassword(String.valueOf(count));
            users.add(tmp);
        }
        // 将数据转换为JSON格式
        Gson gson = new Gson();
        String json = gson.toJson(users);
        // 设置响应头和响应数据
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int right = Integer.parseInt(request.getParameter("right"));
        User user = userService.queryUserById(id);
        if (user.getRight() == -1 && right == -1) {
            response.getWriter().write("-1");
        } else if (user.getRight() == 0 && right == 0) {
            response.getWriter().write('0');
        } else {
            userService.alterUserRight(new User(id, null, null, null, right, null));
            response.getWriter().write('1');
        }
    }
}
