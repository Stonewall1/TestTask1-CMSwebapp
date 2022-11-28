package com.example.test_task1.web.controller;

import com.example.test_task1.service.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private final PageService pageService;

    public MainController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping()
    public String mainMenu(Model model) {
        model.addAttribute("allPages", pageService.allPages());
        return "menu";
    }

}
