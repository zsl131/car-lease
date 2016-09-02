package com.ztw.web;

import com.ztw.exception.MyException;
import com.ztw.iservice.IRoleMenuService;
import com.ztw.iservice.IUserRoleService;
import com.ztw.iservice.IUserService;
import com.ztw.model.User;
import com.ztw.model.UserRole;
import com.ztw.tools.NormalResult;
import com.ztw.tools.NormalResultTools;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsl-pc on 2016/8/31.
 */
@RestController
@RequestMapping(value="user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IRoleMenuService roleMenuService;

    @ApiOperation(value = "添加用户信息", notes = "根据真实姓名和用户名添加用户信息")
    @RequestMapping(value="addUser", method = RequestMethod.GET)
    public String addUser(
            @ApiParam(name = "nickname", value = "用户昵称", required = true)
            @RequestParam String nickname,
            @ApiParam(name = "username", value = "用户名", required = true)
            @RequestParam String username) {
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        userService.save(user);

        return "添加用户成功！";
    }

    @RequestMapping(value="findByUsername", method=RequestMethod.GET)
    @ApiOperation(value = "获取用户", notes ="通过用户名获取对象")
    public User findByUsername(
            @ApiParam(name = "username", value="用户名", required = true)
            @RequestParam String username) throws MyException {
        try {
            User user = userService.findByUsername(username);
//            return "获取用户成功！\nusername:"+user.getUsername()+"\nnickname:"+user.getNickname();
            return user;
        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }
    }

    @RequestMapping(value="queryRoleIds", method=RequestMethod.GET)
    @ApiOperation(value = "获取用户的角色Id", notes = "通过用户Id获取其所拥有的角色Id")
    public NormalResult<String> queryRoleIds(
            @ApiParam(name = "userId", value = "用户Id", required = true)
            @RequestParam(name = "userId") Integer userId) {
        List<Integer> list = userRoleService.queryRoleIds(userId);
        StringBuffer sb = new StringBuffer();
        for(Integer id : list) {
            sb.append(id).append(",");
        }
        sb.append("0");

        return NormalResultTools.getInstance().okResult("获取角色Id成功！", sb.toString());
    }

    @RequestMapping(value="queryMenuIds", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户菜单", notes = "通过用户Id获取其权限范围内的菜单Id")
    public NormalResult<String> queryMenuIds(
            @ApiParam(name = "userId", value = "用户Id", required = true)
            @RequestParam Integer userId) {
        List<Integer> resList = new ArrayList<Integer>();
        List<Integer> roleList = userRoleService.queryRoleIds(userId);

        for(Integer rId : roleList) {
            List<Integer> menuList = roleMenuService.queryMenuIds(rId);
            for(Integer mId : menuList) {
                if(!resList.contains(mId)) {resList.add(mId);}
            }
        }
        StringBuffer sb = new StringBuffer();
        for(Integer id : resList) {
            sb.append(id).append(",");
        }
        sb.append("0");

        return NormalResultTools.getInstance().okResult("获取成功", sb.toString());
    }

    @RequestMapping(value="addOrDelete", method=RequestMethod.GET)
    @ApiOperation(value = "添加或删除用户角色对应关系", notes = "存在则删除，不存在则添加")
    public NormalResult<String> addOrDelete(
            @ApiParam(name = "userId", value = "用户Id", required = true)
            @RequestParam Integer userId,
            @ApiParam(name = "roleId", value = "角色Id", required = true)
            @RequestParam Integer roleId) {
        UserRole ur = userRoleService.findByUidAndRid(userId, roleId);
        if(ur==null) {
            ur = new UserRole();
            ur.setRid(roleId);
            ur.setUid(userId);
            userRoleService.save(ur);
            return NormalResultTools.getInstance().okResult("添加成功!");
        } else {
            userRoleService.delete(ur);
            return NormalResultTools.getInstance().okResult("删除成功!");
        }
    }
}
