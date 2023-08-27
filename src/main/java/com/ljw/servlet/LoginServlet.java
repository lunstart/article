package com.ljw.servlet;

import com.ljw.service.UserService;
import com.ljw.service.impl.UserServiceImpl;
import com.ljw.bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Base64;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login/dopost");
        //设置服务器编码
        response.setCharacterEncoding("UTF-8");
        //设置浏览器编码
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserServiceImpl();
        String new_username = Base64.getEncoder().encodeToString(username.getBytes());
        System.out.println(username);
        System.out.println(new_username);

        int userId = userService.queryIdByUsername(username);
        User user = userService.queryUserById(userId);

        if (user.getRight() == -1) {
            response.getWriter().write("-1");
        } else if (userService.Login(user) != null) {
            response.getWriter().write("1");

            // 1.创建Cookie对象
            Cookie c_username = new Cookie("username", username);
            Cookie c_password = new Cookie("password", password);
            Cookie c_userid = new Cookie("userId", "" + userId);

            // 设置Cookie存活时间
            c_username.setMaxAge(60 * 60 * 24 * 7);
            c_password.setMaxAge(60 * 60 * 24 * 7);
            c_userid.setMaxAge(60 * 60 * 24 * 7);

            // 2.发送
            response.addCookie(c_username);
            response.addCookie(c_password);
            response.addCookie(c_userid);

            // 将登陆成功后的User对象 存储到session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            System.out.println("登录成功");
        } else {
            response.getWriter().write("0");
            System.out.println("密码错误");
        }
    }
}


