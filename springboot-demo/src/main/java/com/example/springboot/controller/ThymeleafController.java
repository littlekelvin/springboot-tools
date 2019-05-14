package com.example.springboot.controller;

import com.example.springboot.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */

@Controller
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("message", "http://baidu.com");
        map.addAttribute("username", "kelvin");
        map.addAttribute("flag", "yes");
        map.addAttribute("age", 50);
        map.addAttribute("name", "kelvin");
        map.addAttribute("sex", "woman");

        List<User> users = new ArrayList<>();
        users.add(new User("aa", "123", 20));
        users.add(new User("bb", "234", 22));
        users.add(new User("cc", "345", 23));
        map.addAttribute("users", users);
        map.addAttribute("type", "link");
        map.addAttribute("img", "http://www.ityouknow.com/assets/images/neo.jpg");
        return "test1";
    }
}
