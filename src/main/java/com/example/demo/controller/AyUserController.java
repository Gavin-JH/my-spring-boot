package com.example.demo.controller;

import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Gavin on 2019/12/22.
 */

@Controller
@RequestMapping("/ayUser")
public class AyUserController {
    @Resource
    private AyUserService ayUserService;
    @RequestMapping("/test")
    public String test(Model model){
        List<AyUser> ayUser=ayUserService.findAll();
        System.out.println("succeed");
        model.addAttribute("users",ayUser);
        return "ayUser";
    }
}
