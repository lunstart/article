package test;

import com.ljw.bean.Collect;
import com.ljw.service.CollectService;
import com.ljw.service.impl.CollectServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollectServletTest {
CollectService collectService = new CollectServiceImpl();

    @Test
    public void doGet() {
    }

    @Test
    public void queryAllById() {
    }

    @Test
    public void deleteCollectById() {
        collectService.deleteCollect(new Collect(null,1,2));
    }

    @Test
    public void addCollect() {
        collectService.addCollect(new Collect(null,1,1));
    }
}