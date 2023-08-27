package com.ljw.servlet;

import com.google.gson.Gson;
import com.ljw.bean.User;
import com.ljw.service.UserService;
import com.ljw.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/setting")
public class SettingServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getId();

        User user1 = userService.queryUserById(id);
        // 将数据转换为JSON格式
        Gson gson = new Gson();
        String json = gson.toJson(user1);
        // 设置响应头和响应数据
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getId();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        userService.alertUser(new User(id,username,password,email,null,null));
        response.getWriter().write("1");
    }
}
