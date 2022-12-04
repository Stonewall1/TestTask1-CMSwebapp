package com.example.test_task1.service;

import com.example.test_task1.dto.EditPageDto;
import com.example.test_task1.dto.PageDto;
import com.example.test_task1.entity.Page;
import com.example.test_task1.repository.PageRepository;
import com.example.test_task1.service.mapper.PageMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class PageService {
    private final PageRepository pageRepository;
    private final PageMapper pageMapper;

    public PageService(PageRepository pageRepository, PageMapper pageMapper) {
        this.pageRepository = pageRepository;
        this.pageMapper = pageMapper;
    }

    public Page save(Page page) {
        pageRepository.save(page);
        return page;
    }

    public Page save(PageDto pageDto) {
        Page page = pageMapper.convertPageDtoToPage(pageDto);
        pageRepository.save(page);
        return page;
    }

    public List<Page> allPagesSortedByPriority() {
        List<Page> list = pageRepository.findAll();
        return list.stream().sorted((o1, o2) -> o2.getPriority() - o1.getPriority()).toList();
    }

    public Page findById(long id) {
        Optional<Page> byId = pageRepository.findById(id);
        return byId.get();
    }

    public void deleteById(long id) {
        pageRepository.deleteById(id);
    }

    public Page editPage(Page page, EditPageDto editPageDto) {
        return pageMapper.convertEditedDtoToPage(page, editPageDto);
    }
}
