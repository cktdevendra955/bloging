package com.core.bloging.payloads;

import com.core.bloging.entity.CategoryEntity;

import java.util.Date;

public class CategoryDto {

    int id;
    String title;
    private String shortDescription;
    Date createdAt;
    Date updatedAt;

    public CategoryDto() {
    }

    public CategoryDto(int id, String title, String shortDescription, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }



}
