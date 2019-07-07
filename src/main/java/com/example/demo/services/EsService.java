package com.example.demo.services;

import com.example.demo.entity.Child;
import com.example.demo.entity.Father;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EsService {
    @Autowired
    private RestClient restClient;
    ObjectMapper mapper = new ObjectMapper();
    private static  final  String URL="/parent-child/_doc";


    public void saveFather(Father f){
        String method = "POST";
        try (NStringEntity entity = new NStringEntity(mapper.writeValueAsString(f), ContentType.APPLICATION_JSON);) {
            Request request = new Request(method, URL);
            request.setEntity(entity);
            Response response = restClient.performRequest(request);
       } catch (Exception e) {
        }
    }

    public void saveSon(Child c,String parentId){
        String method = "POST";
        try (NStringEntity entity = new NStringEntity(mapper.writeValueAsString(c), ContentType.APPLICATION_JSON);) {
            Request request = new Request(method, URL+"?routing="+parentId);
            request.setEntity(entity);
            Response response = restClient.performRequest(request);
        } catch (Exception e) {
        }
    }
}
