package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "parent-child",type="parent")
public class Father {
    @Id
    private String id;
    private String name;
}
