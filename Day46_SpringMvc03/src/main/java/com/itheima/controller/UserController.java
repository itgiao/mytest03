package com.itheima.controller;


import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/add")
    public String addUser(@Valid User user, Errors e, Model model){
        if (e.hasErrors()){
            List<FieldError> fieldErrors = e.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                model.addAttribute(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "redirect:/index.jsp";
        }
        return "success";
    }
}
