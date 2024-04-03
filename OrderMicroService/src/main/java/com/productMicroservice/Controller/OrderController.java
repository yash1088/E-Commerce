/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.productMicroservice.Controller;

import com.productMicroservice.Model.Product;
import com.productMicroservice.Service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

public class OrderController {
    
    @Autowired
    OrderService productservice;
    
    @GetMapping("/data")
    public List<Product> getMsg(){
        List<Product> listproduct = productservice.fetchDataFromApi();
        return listproduct;
    }
    
    @PostMapping("/products")
    public String addProduct(@RequestBody Product p) {
        System.out.println("Helloll");
        System.out.println(p);
        
        String successMessage = "Product added";
        return successMessage;
    }

}
