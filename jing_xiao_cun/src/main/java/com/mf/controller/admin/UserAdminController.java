package com.mf.controller.admin;

import com.mf.entity.User;
import com.mf.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserAdminController {

    @Resource
    private  UserService userService;

    @RequestMapping("/findByUserName")
    public User findByUserName(String username){
        return  userService.findByUserName(username);
    }

    @RequestMapping("/findByUserSign")
    public User findByUserSign(String sign){
        return userService.findByUserSign(sign);
    }

}
