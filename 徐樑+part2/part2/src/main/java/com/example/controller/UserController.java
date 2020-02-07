package com.example.controller;

import java.util.List;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan
@RestController
@EnableAutoConfiguration

public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //增加用户信息
    @RequestMapping("/saveUser")
    public String saveUser(String userName, String userPassword){
        String sql = "insert into user(user_name, user_password) values(?, ?)";
        int rows = jdbcTemplate.update(sql, userName, userPassword);
        return "执行成功，影响" + rows + "行";
    }
    //删除用户信息
    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        String sql = "delete from user where id = ?";
        int rows = jdbcTemplate.update(sql, id);
        return "执行成功，影响" + rows + "行";
    }
    //修改用户信息
    @RequestMapping("/updateUser")
    public String updateUser(int id, String userName, String userPassword){
        String sql = "update user set user_name=? and user_password=? where id = ?";
        int rows = jdbcTemplate.update(sql, userName, userPassword, id);
        return "执行成功，影响" + rows + "行";
    }
    //查询用户信息
    @RequestMapping("/getUser")
    public List getUser(String id){
        String sql = "select * from user where id = ?";
        List<User> list = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        return list;
    }
    public static void main(String[] args) {
        SpringApplication.run(UserController.class, args);
    }

}
