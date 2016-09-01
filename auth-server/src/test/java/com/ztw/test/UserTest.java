package com.ztw.test;

import com.ztw.RootApplication;
import com.ztw.iservice.IUserService;
import com.ztw.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by zsl-pc on 2016/9/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = RootApplication.class)
public class UserTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testAllUser() {
        User user = new User();
        user.setNickname("李四");
        user.setUsername("lisi");
        user.setStatus(1);
        userService.save(user);
    }
}
