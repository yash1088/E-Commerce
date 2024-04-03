package com.springBoot.Service;


import com.springBoot.Model.MyData;
import com.springBoot.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Service
public class ApiServiceMicro {

    @Autowired
    RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> fetchDataFromApi() {
        String apiUrl = "http://Product-Microservice/data";
         
        // Make a GET request to the APIMyData[] dataArray = restTemplate.getForObject(apiUrl, MyData[].class);
        try {
            System.out.println("Hii");
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            
            List<Product> dataArray = restTemplate.getForObject(apiUrl, List.class);
            List<Product> dataList = dataArray;
        for(int i=0;i<dataList.size();i++){
            System.out.println("******************************");
            System.out.println(dataList.get(i));
            System.out.println("*******************************");
        }
        return dataList;
            
            // Process the dataArray
        } catch (Exception e) {
            System.out.println("*********" + e.getMessage());
            // Handle the exception
        }
        // Convert the array to a List
        return null;
    }
}
