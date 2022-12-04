package com.example.test_task1.service.mapper;

import com.example.test_task1.dto.EditPageDto;
import com.example.test_task1.dto.PageDto;
import com.example.test_task1.entity.Page;
import org.springframework.stereotype.Component;


@Component
public class PageMapper {
    public Page convertPageDtoToPage(PageDto pageDto) {
        return new Page(pageDto.getTitle(),
                pageDto.getDescription(),
                pageDto.getMenu_label(),
                pageDto.getH1(),
                pageDto.getPublished_at(),
                pageDto.getPriority());
    }

    public Page convertEditedDtoToPage(Page page, EditPageDto editPageDto) {
        page.setTitle(editPageDto.getTitle());
        page.setDescription(editPageDto.getDescription());
        page.setMenu_label(editPageDto.getMenu_label());
        page.setH1(editPageDto.getH1());
        page.setPriority(editPageDto.getPriority());
        return page;
    }
}
