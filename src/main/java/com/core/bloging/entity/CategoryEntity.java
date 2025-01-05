package com.core.bloging.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "blogig_new_categories")
public class CategoryEntity extends BaseEntity{

    private String title;
    @Column(name = "short_description")
    private String shortDescription;


    public CategoryEntity() {
    }

    public CategoryEntity(String title, String shortDescription) {
        this.title = title;
        this.shortDescription = shortDescription;
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
}
