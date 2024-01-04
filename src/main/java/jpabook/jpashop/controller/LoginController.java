package jpabook.jpashop.controller;

import jakarta.servlet.http.HttpServletResponse;
import jpabook.jpashop.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Slf4j
@Controller

public class LoginController {


    LoginService loginService;

//    @GetMapping("/login")
//    public void getGoogleAuth(HttpServletResponse response) throws IOException {
////        log.info("initURL={}",);
//        System.out.println("he");
//    }

    @GetMapping("login")
    public String login() {
        return "login";
    }
}
