package test;

import com.ljw.bean.User;
import com.ljw.dao.UserDao;
import com.ljw.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
UserDao userDao = new UserDaoImpl();
    @Test
    public void querySearch() {
        System.out.println(userDao.querySearch("海").toString());
    }
}