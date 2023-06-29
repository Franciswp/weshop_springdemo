package com.example.demospring.controller;

import com.example.demospring.data.dao.CategoryDao;
import com.example.demospring.data.entities.CategoryEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final CategoryDao categoryDao;

    @Transactional
    @GetMapping(path = "/getSomething")
    public String getSomething(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("Test");
        categoryDao.addCategory(categoryEntity);
        return  "Test String";
    }
}
