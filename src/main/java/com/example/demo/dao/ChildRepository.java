package com.example.demo.dao;


import com.example.demo.entity.Child;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ChildRepository extends ElasticsearchRepository<Child, String> {
}
