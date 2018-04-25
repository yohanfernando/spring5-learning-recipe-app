package xyz.yohanfernando.sguru.spring5recipeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        System.out.println("Loading index page @ " + new Date());
        return "index";
    }
}
