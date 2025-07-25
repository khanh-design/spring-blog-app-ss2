package com.example.springblogappss2.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/api")
public class RestAdminController {
    @GetMapping("/admin")
    public ModelAndView admin() {
        return new ModelAndView("/admin");
    }
}
