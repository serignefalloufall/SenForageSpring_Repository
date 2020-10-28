package com.simplon.senForageSpringProject.controller;

import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Security;

@Controller
public class AdminController {

    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/logon";
    }

    @RequestMapping(value = "")
    public String home() {
        return "redirect:/logon";
    }

    @RequestMapping(value = "/logon")
    public String logon(ModelMap map, HttpServletRequest req, HttpServletResponse res) {
        String user = req.getRemoteUser();//requperation email user conecte
        //System.out.println("Principale is :" + user);
       // String name = SecurityContextHolder.getContext().getAuthentication().getName();
       // System.out.println("Principale is :" + name);
        if (user != null)
            return "accueil";
        else
            return "redirect:/login";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/Admin/403")
    public String denied() {
        return "403";
    }

}
