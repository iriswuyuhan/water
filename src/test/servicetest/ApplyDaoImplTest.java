package servicetest;

import com.water.dao.ApplyDao;
import com.water.dao.Impl.ApplyDaoImpl;
import com.water.entity.Apply;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhanglei on 2017/7/24.
 */
public class ApplyDaoImplTest extends TestCase {
    ApplyDao applyDao=new ApplyDaoImpl();

    public void testFindApplyById() throws Exception {
        System.out.println("sss");
        List<Apply> list= applyDao.findApplyById("zhs");
        System.out.println(list.size());
        assertEquals("1",list.size());

    }

}