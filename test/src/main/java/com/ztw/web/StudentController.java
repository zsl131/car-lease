package com.ztw.web;

import com.ztw.model.Student;
import com.ztw.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zsl-pc on 2016/9/2.
 */
@RestController
@RequestMapping(value="student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value="addStu", method = RequestMethod.GET)
    @ApiOperation(value = "添加学员", notes = "通过姓名和身份证号添加学员")
    public String addStu(
            @ApiParam(name = "name", value = "姓名", required = true)
            @RequestParam String name,

            @ApiParam(name = "identity", value = "身份证号", required = true)
            @RequestParam String identity) {
        Student stu = new Student();
        stu.setIdentity(identity);
        stu.setName(name);
        studentService.save(stu);
        return "添加成功";
    }

    @RequestMapping(value="findByIden", method = RequestMethod.GET)
    @ApiOperation(value = "获取学员信息", notes = "通过身份证号获取信息")
    public String findByIden(
            @ApiParam(name = "identity", value = "身份证号", required = true)
            @RequestParam String identity) {
        Student stu = studentService.findByIdentity(identity);
        return "获取成功\nname:"+stu.getName()+"\nidentity:"+stu.getIdentity();
    }

    @RequestMapping(value="findAll", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有", notes = "sdfsadfasdfsdf")
    public List<Student> findAll() {
        List<Student> list = studentService.findAll();
        return list;
    }

    @RequestMapping(value="findAllDatas", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有2", notes = "sdfsadfasdfsdf")
    public List<Student> findAllDatas() {
        List<Student> list = studentService.findAll();
        return list;
    }

    @RequestMapping(value="findByParam", method = RequestMethod.GET)
    @ApiOperation(value = "通过参数获取", notes = "通过姓名身份证号获取")
    public Student findByParm(
            @ApiParam(name = "name", value = "姓名")
            @RequestParam(defaultValue = "张三") String name,

            @ApiParam(name = "identity", value = "身份证号")
            @RequestParam(defaultValue = "123") String identity) {
        Student stu = studentService.findByNameAndIdentity(name, identity);
        return stu;
    }
}
