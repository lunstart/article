package test;

import com.ljw.dao.UserDao;
import com.ljw.dao.impl.UserDaoImpl;
import com.ljw.service.UserService;
import com.ljw.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserService  userService = new UserServiceImpl();

    @Test
    public void queryUsernameById() {
        System.out.println(userService.queryUsernameById(1));
    }
}