package com.dexlock.SpringDemo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping("home")
    public void home(HttpServletRequest req){
        String name = req.getParameter("name");
        System.out.println("Yayyy...You reached home!!!"+name);
    }
}
