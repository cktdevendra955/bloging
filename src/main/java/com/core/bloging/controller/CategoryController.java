package com.core.bloging.controller;

import com.core.bloging.payloads.ApiResponse;
import com.core.bloging.payloads.CategoryDto;
import com.core.bloging.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll(){
        return new ResponseEntity<>(this.categoryService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(this.categoryService.create(categoryDto),HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable Integer id){
        return new ResponseEntity<>(this.categoryService.getById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> create(Integer id,@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(this.categoryService.updateById(id, categoryDto),HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteById(Integer ic){
        return new ResponseEntity<ApiResponse>(new ApiResponse("1 Row SuccessfullyDeleted ", true),HttpStatus.OK);
    }

}
