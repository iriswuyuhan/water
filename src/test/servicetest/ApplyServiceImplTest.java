package servicetest;

import com.water.entity.Apply;
import com.water.entity.User;
import com.water.service.ApplyService;
import com.water.service.Impl.ApplyServiceImpl;
import com.water.service.Impl.UserServiceImpl;
import com.water.service.UserService;
import junit.framework.TestCase;

import java.util.Date;

/**
 * Created by zhanglei on 2017/7/24.
 */
public class ApplyServiceImplTest extends TestCase {

    public void testAddApply() throws Exception {
        ApplyService applyService=new ApplyServiceImpl();
        Date date=new Date();
        User user=new User();
        user.setIdUser("001");
        user.setAddress("sss");
        user.setIsResearcher(0);
        user.setName("sss");
        user.setPassword("sss");
        Apply apply=new Apply();
        apply.setAddress("南大");
        apply.setApplyDate(date);
        apply.setImage("/image/11");
        apply.setLatitude(11.11);
        apply.setLongitude(22.22);
        apply.setName("小明");
        apply.setNumber("1111");
        apply.setState(0);
        apply.setUser(user);
        apply.setWaterAddress("黄河");
        boolean result=applyService.addApply(apply);
        System.out.println(apply.getIdApply());
        assertEquals(true,result);

    }

}