package com.ztw.web;

import com.ztw.iservice.IMenuService;
import com.ztw.model.Menu;
import com.ztw.service.MenuServiceImpl;
import com.ztw.tools.NormalResult;
import com.ztw.tools.NormalResultTools;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zsl-pc on 2016/9/1.
 */
@RestController
@RequestMapping(value="menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private MenuServiceImpl menuServiceImpl;

    @RequestMapping(value="findByPid", method = RequestMethod.GET)
    @ApiOperation(value = "获取菜单", notes = "pid为空获取根菜单，不为空获取对应子菜单")
    public NormalResult<List<Menu>> findByPid(
            @ApiParam(name = "pid", value = "父Id")
            @RequestParam(defaultValue = "0") Integer pid,

            @ApiParam(name = "type", value = "类型，只能传1或2")
            @RequestParam(defaultValue = "") String type) {
        List<Menu> list = menuServiceImpl.findByPid(pid, type);
        return NormalResultTools.getInstance().okResult("获取菜单成功", list);
    }

    @RequestMapping(value="findByUser", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户菜单", notes = "根据用户Id获取其权限范围内的菜单")
    public NormalResult<List<Menu>> findByUser(
            @ApiParam(name = "userId", value = "用户Id", required = true)
            @RequestParam Integer userId) {
        List<Menu> list = menuService.findByUser(userId);

        return NormalResultTools.getInstance().okResult("获取菜单成功", list);
    }
}
