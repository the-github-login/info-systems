package ru.kpfu.lawhelp.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {

    @RequestMapping("/")

    public String profile(HttpServletRequest request) {
        return "mainPage";
    }
}
