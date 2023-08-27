package test;

import com.ljw.bean.Collect;
import com.ljw.dao.CollectDao;
import com.ljw.dao.impl.CollectDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollectDaoImplTest {
    CollectDao collectDao = new CollectDaoImpl();
    @Test
    public void addCollect() {
        collectDao.addCollect(new Collect(null,1,2));
    }

    @Test
    public void deleteCollect() {
    }

    @Test
    public void queryCollectById() {
    }
}