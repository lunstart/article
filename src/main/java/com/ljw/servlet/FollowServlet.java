package com.ljw.servlet;

import com.google.gson.Gson;
import com.ljw.bean.Follow;
import com.ljw.bean.User;
import com.ljw.service.FollowService;
import com.ljw.service.UserService;
import com.ljw.service.impl.FollowServiceImpl;
import com.ljw.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/follow/*")
public class FollowServlet extends HttpServlet {
    private FollowService followService = new FollowServiceImpl();
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int followId = Integer.parseInt(request.getParameter("followId"));
        System.out.println(followId);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        System.out.println(userId);
        if (userId == followId) {
            //不能自己
            response.getWriter().write("2");
        } else if (!(followService.isFollow(userId, followId))) {
            //未关注
            followService.addFollow(new Follow((Integer) null, userId, followId));
            response.getWriter().write("1");
        } else {
            //不能重复
            response.getWriter().write("0");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("follow/* doGet");

        String path = request.getPathInfo();
        System.out.println(path);
        System.out.println("path=" + path);

        if (path == null) {
            // 如果路径为空，返回错误响应
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        if (path.equals("/queryFollowById")) {
            queryFollowById(request, response);
        } else if (path.equals("/deleteFollowById")) {
            deleteFollowById(request, response);
        } else {
            // 如果路径不匹配，返回错误响应
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }

    protected void queryFollowById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("queryFollowById");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getId();

        List<User> follows = new ArrayList<User>();
        for (Follow tmp : followService.queryFollow(id)) {
            User user1 = new User();
            user1.setId(tmp.getFollow_user_id());
            System.out.println(tmp.getFollow_user_id());
            user1.setUsername(userService.queryUsernameById(tmp.getFollow_user_id()));
            System.out.println(userService.queryUsernameById(tmp.getFollow_user_id()));
            follows.add(user1);
        }
        for (User tmp : follows) {
            System.out.println(tmp.getId());
        }
        Gson gson = new Gson();
        String json = gson.toJson(follows);
        // 设置响应头和响应数据
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    protected void deleteFollowById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("deleteFollowById");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        int FollowId = Integer.parseInt(request.getParameter("id"));
        followService.deleteFollow(new Follow(null, userId, FollowId));
        response.getWriter().write("1");
    }
}
