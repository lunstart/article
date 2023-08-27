package test;

import com.ljw.service.UserService;
import com.ljw.service.impl.UserServiceImpl;
import com.ljw.bean.User;
import org.junit.Test;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"莫言","123456",null,null,null));
        //userService.registUser(new User(null,"lisi","654321",null,null,null));
    }

    @Test
    public void login() {
        //System.out.println(userService.Login(new User(null,"zhangsan","123456",null,null,null,null)));
        if((userService.Login(new User(null,"人民日报","123456",null,null,null))) == null){
        System.out.println("用户名或密码错误");
        }
        else System.out.println("登录成功");
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("admin"))
            System.out.println("用户名已存在");
    }

    @Test
    public void alertUser(){
        userService.alertUser(new User(10,"测试用名","123456","test@test.com",null,null));
    }
}