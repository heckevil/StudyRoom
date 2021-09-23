package com.security.test.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class MemberController {
    @Autowired
    private MemberService service;

    @RequestMapping("/login")
    public String login(){
        return "/user/login";
    }
    @RequestMapping("/join")
    public String join(){
        return "/user/join";
    }
    @RequestMapping(value = "join",method = RequestMethod.POST)
    public String join(UserEntity param){
        service.join(param);
        return "redirect:/user/success";
    }
    @RequestMapping("/login/result")
    public String loginResult(){
        return "/user/loginResult";
    }

    @GetMapping("/user/denied")
    public String Denied() {
        return "/user/denied";
    }
}
