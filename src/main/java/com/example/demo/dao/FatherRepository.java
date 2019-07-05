package com.example.demo.dao;

import com.example.demo.entity.Father;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface FatherRepository extends ElasticsearchRepository<Father, String> {
}
