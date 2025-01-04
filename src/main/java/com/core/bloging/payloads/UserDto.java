package com.core.bloging.payloads;

import java.util.Date;

public class UserDto {
    private int id;
    private  String name;
    private  String email;
    private  String password;
    private  String about;
    private Date createdAt;
    private Date updateddAt;

    public UserDto() {
    }

    public UserDto(int id, String name, String email, String password, String about, Date createdAt, Date updateddAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.about = about;
        this.createdAt = createdAt;
        this.updateddAt = updateddAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDto(String name, String email, String password, String about, Date createdAt, Date updateddAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.about = about;
        this.createdAt = createdAt;
        this.updateddAt = updateddAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateddAt() {
        return updateddAt;
    }

    public void setUpdateddAt(Date updateddAt) {
        this.updateddAt = updateddAt;
    }

    public UserDto(String name, String email, String password, String about) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
