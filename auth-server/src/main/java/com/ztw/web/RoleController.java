package com.ztw.web;

import com.ztw.iservice.IRoleMenuService;
import com.ztw.iservice.IRoleService;
import com.ztw.model.RoleMenu;
import com.ztw.tools.NormalResult;
import com.ztw.tools.NormalResultTools;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zsl-pc on 2016/9/1.
 */
@RestController
@RequestMapping(value="role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IRoleMenuService roleMenuService;

    @RequestMapping(value="queryMenuIds", method= RequestMethod.GET)
    @ApiOperation(value = "查询角色拥有的菜单Id", notes = "通过角色Id查询其拥有的菜单Id")
    @ApiImplicitParam(name = "roleId", value = "角色Id", required = true, dataType = "Integer")
    @ApiParam(name = "roleId", value = "角色Id", required = true)
    public NormalResult<String> queryMenuIds(Integer roleId) {
        List<Integer> list = roleMenuService.queryMenuIds(roleId);
        StringBuffer sb = new StringBuffer();
        for(Integer id : list) {
            sb.append(id).append(",");
        }
        sb.append("0");

//        return sb.toString();
        return NormalResultTools.getInstance().okResult("查询成功", sb.toString());
    }

    @RequestMapping(value="addOrDelete", method=RequestMethod.GET)
    @ApiOperation(value = "添加或删除角色菜单", notes = "存在对象则删除，不存在则添加")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "roleId", value = "角色Id", required = true, dataType = "Integer"),
        @ApiImplicitParam(name = "menuId", value = "菜单Id", required = true, dataType = "Integer")
    })
    public NormalResult<String> addOrDelete(Integer roleId, Integer menuId) {
        RoleMenu rm = roleMenuService.queryByRidAndMid(roleId, menuId);
        if(rm==null) {
            rm = new RoleMenu();
            rm.setMid(menuId);
            rm.setRid(roleId);
            roleMenuService.save(rm);
//            return "保存成功！";
            return NormalResultTools.getInstance().okResult("保存成功！");
        } else {
            roleMenuService.delete(rm);
//            return "删除成功！";
            return NormalResultTools.getInstance().okResult("删除成功！");
        }
    }
}
