package com.ztw.test;

import com.ztw.RootApplication;
import com.ztw.model.Menu;
import com.ztw.service.MenuServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by zsl-pc on 2016/9/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(RootApplication.class)
public class MenuTest {

    @Autowired
    private MenuServiceImpl menuService;

    @Test
    public void testMenu() {
        List<Menu> list = menuService.findByPid(0, null);
        System.out.println(list.size());
    }
}
