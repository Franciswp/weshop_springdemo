package com.example.demospring.controller;

import com.example.demospring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/web.html")
    public String getWebPage(Model model){
        model.addAttribute("myVariable",studentService.getAllStudents());
        return "text.html";
    }

}
