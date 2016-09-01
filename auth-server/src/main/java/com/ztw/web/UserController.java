package com.ztw.web;

import com.ztw.iservice.IUserService;
import com.ztw.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zsl-pc on 2016/8/31.
 */
@RestController
@RequestMapping(value="user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "添加用户信息", notes = "根据真实姓名和用户名添加用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name="realname", value="真实姓名", required = true, dataType = "String"),
        @ApiImplicitParam(name="username", value="用户名", required = true, dataType = "String")
    })
    @RequestMapping(value="addUser", method = RequestMethod.GET)
    public String addUser(@PathVariable String realname, @PathVariable String username) {
        User user = new User();
        user.setUsername(username);
        user.setRealname(realname);
        userService.save(user);

        return "添加用户成功！";
    }
}
