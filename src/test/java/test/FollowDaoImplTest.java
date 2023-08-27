package test;

import com.ljw.bean.Follow;
import com.ljw.dao.FollowDao;
import com.ljw.dao.impl.FollowDaoImpl;
import org.junit.Test;

public class FollowDaoImplTest {
    FollowDao followDao = new FollowDaoImpl();
    @Test
    public void addFollow() {
    }

    @Test
    public void deleteFollowById() {
    }

    @Test
    public void queryFollowById() {

    }

    @Test
    public void queryFollow() {
        for (Follow tmp : followDao.queryFollow(1)
        ) {
            System.out.println(tmp.toString());
        }

    }
}