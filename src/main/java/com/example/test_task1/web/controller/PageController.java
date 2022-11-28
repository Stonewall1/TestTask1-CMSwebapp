package com.example.test_task1.web.controller;

import com.example.test_task1.dto.PageDto;
import com.example.test_task1.service.PageService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/add")
    public String addPage(@ModelAttribute("newPage") PageDto pageDto) {
        return "addPage";
    }

    @PostMapping("/add")
    public String addPage(@Valid @ModelAttribute("newPage") PageDto pageDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "addPage";
        }
        pageService.save(pageDto);
        return "redirect:/";
    }
}
