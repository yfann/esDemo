package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Parent;

@Data
@Document(indexName = "parent-child",type="_doc")
public class Child {
    @Id
    private String id;
    private String name;
    private Sub sub;
    public Child(){
        this.sub=new Sub("son");
    }
}
