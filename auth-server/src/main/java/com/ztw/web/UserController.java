package com.ztw.web;

import com.ztw.exception.MyException;
import com.ztw.iservice.IUserService;
import com.ztw.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        @ApiImplicitParam(name="nickname", value="真实姓名", required = true, dataType = "String"),
        @ApiImplicitParam(name="username", value="用户名", required = true, dataType = "String")
    })
    @RequestMapping(value="addUser", method = RequestMethod.GET)
    public String addUser(String nickname, String username) {
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        userService.save(user);

        return "添加用户成功！";
    }

    @RequestMapping(value="findByUsername", method=RequestMethod.GET)
    @ApiOperation(value = "获取用户", notes ="通过用户名获取对象")
    @ApiImplicitParam(name = "username", value="用户名", required = true, dataType = "String")
    public String findByUsername(String username) throws MyException {
        try {
            User user = userService.findByUsername(username);
            return "获取用户成功！\nusername:"+user.getUsername()+"\nnickname:"+user.getNickname();
        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }
    }
}
