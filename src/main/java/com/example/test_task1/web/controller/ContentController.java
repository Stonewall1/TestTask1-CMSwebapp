package com.example.test_task1.web.controller;

import com.example.test_task1.dto.EditPageDto;
import com.example.test_task1.dto.PageDto;
import com.example.test_task1.entity.Page;
import com.example.test_task1.service.PageService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/content")
public class ContentController {
    private final PageService pageService;

    public ContentController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/add")
    public String addPage(@ModelAttribute("newPage") PageDto pageDto) {
        return "addPage";
    }

    @PostMapping("/add")
    public String addPage(@Valid @ModelAttribute("newPage") PageDto pageDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addPage";
        }
        pageService.save(pageDto);
        return "redirect:/";
    }

    @GetMapping("/current")
    public String currentPage(long pageId, Model model) {
        Page byId = pageService.findById(pageId);
        model.addAttribute("page", byId);
        return "content";
    }

    @PostMapping("/delete")
    public String deletePage(long pageId) {
        pageService.deleteById(pageId);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updatePage(long pageId, @ModelAttribute("editedPage") EditPageDto editPageDto, Model model) {
        model.addAttribute("page", pageService.findById(pageId));
        return "editPage";
    }

    @PostMapping("/update")
    public String updatePage(long id, @Valid @ModelAttribute("editedPage") EditPageDto editPageDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editPage";
        }
        Page byId = pageService.findById(id);
        Page editedPage = pageService.editPage(byId, editPageDto);
        pageService.save(editedPage);
        return "redirect:/content/current";
    }
}
