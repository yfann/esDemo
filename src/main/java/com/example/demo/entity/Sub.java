package com.example.demo.entity;

import lombok.Data;

@Data
public class Sub {
    private String name;
    private String parent;
    public Sub(String n){
        this.name=n;
    }
}
