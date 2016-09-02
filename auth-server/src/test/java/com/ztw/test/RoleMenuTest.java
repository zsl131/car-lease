package com.ztw.test;

import com.ztw.RootApplication;
import com.ztw.iservice.IMenuService;
import com.ztw.iservice.IRoleMenuService;
import com.ztw.iservice.IRoleService;
import com.ztw.model.Menu;
import com.ztw.model.Role;
import com.ztw.model.RoleMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by zsl-pc on 2016/9/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RootApplication.class)
@WebAppConfiguration
public class RoleMenuTest {

    @Autowired
    private IRoleMenuService roleMenuService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMenuService menuService;

    @Test
    public void testMenu() {
        List<Menu> list = menuService.findByUser(1);
        System.out.println(list.size());
    }

    @Test
    public void addRole() {
        Role r = new Role();
        r.setName("测试角色");
        r.setSn("test_role");
        roleService.save(r);
    }

    @Test
    public void addMenu() {
        for(int i=0; i<=10; i++) {
            Menu m = new Menu();
            m.setName("测试菜单 "+i);
            m.setSn("test menu "+i);
            m.setHref("#");
            m.setDisplay(1);
            m.setOrderNum(i+1);
            m.setType("1");

            menuService.save(m);
        }
    }

    @Test
    public void testRoleMenu() {
        List<Integer> list = roleMenuService.queryMenuIds(1);
        System.out.println("========totle: "+list.size());
        for(Integer id : list) {
            System.out.println("======="+id);
        }
    }

    @Test
    public void testQueryRoleMenu() {
        RoleMenu rm = roleMenuService.queryByRidAndMid(1, 3);
        System.out.println("=========-=-=-"+rm.getId());
    }
}
