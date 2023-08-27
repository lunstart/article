package test;

import com.ljw.bean.Collect;
import com.ljw.service.CollectService;
import com.ljw.service.impl.CollectServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollectServiceImplTest {
    CollectService collectService = new CollectServiceImpl();

    @Test
    public void addCollect() {
    }

    @Test
    public void deleteCollect() {
    }

    @Test
    public void queryAllById() {
    }

    @Test
    public void isCollect() {
        System.out.println(collectService.isCollect(new Collect(null,1,1)));
    }
}