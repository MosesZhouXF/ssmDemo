package com.moses.web;

import com.moses.dto.LoginResult;
import com.moses.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2016-11-22.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    public String login(@RequestParam("userId") String userId,@RequestParam("password") String password, Model model){
        LoginResult loginResult = loginService.doLogin(userId, password);
        if(loginResult.getState() == 1){
            model.addAttribute("result",loginResult);
            return "welcome";
        }else{
            model.addAttribute("result",loginResult);
            return "index.jsp";
        }
    }
}
