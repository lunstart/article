package test;

import com.ljw.bean.Follow;
import com.ljw.service.FollowService;
import com.ljw.service.impl.FollowServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class FollowServletTest {

    private FollowService followService = new FollowServiceImpl();
    @Test
    public void doPost() {
    }

    @Test
    public void doGet() {
    }

    @Test
    public void queryFollowById() {
    }

    @Test
    public void cancelFollowById() {
        followService.deleteFollow(new Follow(null,1,14));
    }
}