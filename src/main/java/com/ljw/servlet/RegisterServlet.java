package com.ljw.servlet;

import com.ljw.service.UserService;
import com.ljw.service.impl.UserServiceImpl;
import com.ljw.bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println("-----------------");

        UserService userService = new UserServiceImpl();
        //设置服务器编码
        response.setCharacterEncoding("UTF-8");
        //设置浏览器编码
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        if (!(userService.existsUsername(username))) {
            userService.registUser(new User(null, username, password, null, null, null));
            response.getWriter().write("1");
            System.out.println("注册成功");
            System.out.println("-------------");
        } else {
            System.out.println("用户名重复");
            response.getWriter().write("0");
            System.out.println("-------------");
        }
    }
}
