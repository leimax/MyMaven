package com.css.domain;

public class User {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name == null ? null : name.trim();
    }
}