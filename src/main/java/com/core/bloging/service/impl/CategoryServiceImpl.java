package com.core.bloging.service.impl;

import com.core.bloging.entity.CategoryEntity;
import com.core.bloging.exceptions.ResourceNotFundException;
import com.core.bloging.payloads.CategoryDto;
import com.core.bloging.repository.CategoryRepo;
import com.core.bloging.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<CategoryDto> getAll() {
        List<CategoryEntity> listOfCategoryEntity = this.categoryRepo.findAll();

        List<CategoryDto> listOfCategoryDTO = new ArrayList<>();

        for (CategoryEntity category : listOfCategoryEntity) {
            CategoryDto categoryDto = this.entityToDto(category);
            listOfCategoryDTO.add(categoryDto);
        }
//        List<CategoryDto> categories = listOfCategoryEntity.stream()
//                .map(listOfCategoryEntity -> this.entityToDto(listOfCategoryEntity)).collect(Collectors.toList());
//        return  categories;

        return listOfCategoryDTO;
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        CategoryEntity entity = this.DtoToEntity(categoryDto);
        entity.setCreatedAt(new Date());
        CategoryEntity save = this.categoryRepo.save(entity);
        return this.entityToDto(save);
    }

    @Override
    public CategoryDto getById(Integer id) {
        CategoryEntity category = this.categoryRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFundException("Category ", "ID ",id));
        return this.entityToDto(category);
    }

    @Override
    public CategoryDto updateById(Integer id, CategoryDto categoryDto) {
        CategoryEntity category = this.categoryRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFundException("Category ", "ID ",id));

        category.setTitle(categoryDto.getTitle());
        category.setShortDescription(categoryDto.getShortDescription());
        category.setUpdatedAt(categoryDto.getUpdatedAt());
        CategoryEntity save = this.categoryRepo.save(category);
        return this.entityToDto(save);
    }

    @Override
    public void deletById(Integer id) {
        CategoryEntity category = this.categoryRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFundException("Category ", "ID ",id));
    }


    public CategoryEntity DtoToEntity(CategoryDto dto){
        CategoryEntity category = new CategoryEntity();
        category.setId(dto.getId());
        category.setTitle(dto.getTitle());
        category.setShortDescription(dto.getShortDescription());
        category.setCreatedAt(dto.getCreatedAt());
        category.setUpdatedAt(dto.getUpdatedAt());
        return category;
    }


    public CategoryDto entityToDto(CategoryEntity entity){
        CategoryDto dto = new CategoryDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setShortDescription(entity.getShortDescription());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
