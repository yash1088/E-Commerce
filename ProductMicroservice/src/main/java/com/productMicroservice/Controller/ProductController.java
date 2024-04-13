/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.productMicroservice.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.productMicroservice.Model.Data;
import com.productMicroservice.Model.Product;
import com.productMicroservice.Service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yash
 */

@RestController
public class ProductController {
    
    @Autowired
    ProductService productservice;
    
    
    
    @GetMapping("/data")
    public List<Product> getMsg(){
        System.out.println("data");
        List<Product> listproduct = productservice.getProduct();
        return listproduct;
    }
    
    @PostMapping("/products")
    public String addProduct(@RequestBody Product p) {
        System.out.println("Helloll");
        System.out.println(p);
        int result = productservice.save(p);
        String successMessage = "";
        if(result==1){
            successMessage = "Product added";
        }else{
            successMessage = "Error";
        }
        
        return successMessage;
    }
    
    
    @GetMapping("/addproducts")
    public void addProductsFromJson() throws JsonProcessingException {
        Data data = new Data();
        System.out.println(data.jsonData);
//        ObjectMapper mapper = new ObjectMapper();
//
//        
//        // Deserialize JSON data to Product object
//        List<Product> products = mapper.readValue(data.jsonData , new TypeReference<List<Product>>(){});
//
//        // Add each product to the database
//        for (Product product : products) {
//            System.out.println("JSOn.."+product);
//        }
//        for (Product product : products) {
//            productservice.save(product);
//        }
        
    }
    
}