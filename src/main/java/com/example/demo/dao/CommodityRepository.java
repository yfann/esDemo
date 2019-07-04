package com.example.demo.dao;

import com.example.demo.entity.Commodity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface CommodityRepository extends ElasticsearchRepository<Commodity, String> {

}
