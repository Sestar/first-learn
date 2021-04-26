package com.sestar.bootmultiple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring Boot 自定义 Jsp
 *
 * @author zhangxinxin
 * @date 2019/5/20 17:45
 **/
@Controller
@RequestMapping("/jsp")
public class JspController {

    @GetMapping("/index")
    public String index(Model model) {

        model.addAttribute("message", "World");

        return "index";
    }

}
