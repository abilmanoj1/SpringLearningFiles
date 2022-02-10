package com.dexlock.SpringSecurityDemo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class APIController {

    @GetMapping("/")
    public String Printer(){
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String PrinterUser(){
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String PrinterAdmin(){
        return ("<h1>Welcome Admin</h1>");
    }
}
