package com.cetys.rating.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class ErrorCustomController implements ErrorController  {
    
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {

        
        
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        model.addAttribute("statusCode", statusCode);
       
        return "/public/errorx";
        
    }  
}
