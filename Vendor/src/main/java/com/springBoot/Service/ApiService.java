package com.springBoot.Service;

import com.springBoot.Model.MyData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Service
public class ApiService {

    RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<MyData> fetchDataFromApi() {
        String apiUrl = "https://api.slingacademy.com/v1/sample-data/photos?offset=5&limit=100";
         
        // Make a GET request to the APIMyData[] dataArray = restTemplate.getForObject(apiUrl, MyData[].class);
        try {
            System.out.println("Hii");
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            
            MyData dataArray = restTemplate.getForObject(apiUrl, MyData.class);
            List<MyData> dataList = Arrays.asList(dataArray);
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
