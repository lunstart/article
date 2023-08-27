package test;

import com.ljw.bean.Follow;
import com.ljw.service.FollowService;
import com.ljw.service.impl.FollowServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class FollowServiceImplTest {

    private FollowService followService = new FollowServiceImpl();
    @Test
    public void addFollow() {
    }

    @Test
    public void isFollow() {
        System.out.println(followService.isFollow(1, 15));
    }

    @Test
    public void deleteFollow() {
followService.deleteFollow(new Follow(null,1,15));
    }

    @Test
    public void queryFollow() {

    }
}