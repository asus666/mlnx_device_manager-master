import com.mlnx.device_manager.DeviceManagerServiceApplication;
import com.mlnx.device_manager.impl.UserServiceIml;
import com.mlnx.device_manager.mappers.TUserMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by amanda.shan on 2019/1/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DeviceManagerServiceApplication.class)
public class DeviceManagerTest {

    @Autowired
    UserServiceIml userService;

    @Autowired
    TUserMapper tUserMapper;

    @Test
    public void test(){
        userService.login("mlnx", "mlnx");

//        tUserMapper.selectList(new QueryWrapper<User>());
    }
}
