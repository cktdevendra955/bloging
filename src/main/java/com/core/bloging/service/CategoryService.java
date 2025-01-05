package com.core.bloging.service;

import com.core.bloging.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAll();
    CategoryDto create(CategoryDto categoryDto);
    CategoryDto getById(Integer id);
    CategoryDto updateById(Integer id,CategoryDto categoryDto);
    void deletById(Integer id);


}
