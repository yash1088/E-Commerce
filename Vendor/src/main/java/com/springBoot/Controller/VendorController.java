package com.springBoot.Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.springBoot.Model.Product;
import com.springBoot.Service.ApiServiceMicro;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.ApplicationScope;

@Controller
public class VendorController {
    
    @Autowired
    ApiServiceMicro api;
    
    @Autowired
    RestTemplate restTemplate;
    
//    @Value("http://Product-Microservice/product")
//    private String productMicroserviceUrl;
    
    @RequestMapping("/first")
    public String redirect(HttpServletRequest req, Model m) {
        System.out.println("First........");
        return "first";
    }

    @RequestMapping("/second")
    public String display(HttpServletRequest req, Model m) {
        System.out.println("SecondPage");
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        m.addAttribute("name", name);
        m.addAttribute("pass", pass);
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        m.addAttribute("cars",cars);
        return "second";
    }
    
    @RequestMapping("/dashboard")
    public String dashboard() {
        System.out.println("Dashboard");
        return "Dashboard";
    }
    
    
    
    
    
    @RequestMapping("/customers")
    public String customers() {
        System.out.println("customers");
        return "customers";
    }
    
    @RequestMapping("/orders")
    public String orders() {
        System.out.println("orders");
        return "orders";
    }
    
    @RequestMapping("/settings")
    public String settings() {
        System.out.println("settings");
        return "settings";
    }
    
    
    @RequestMapping("/addproduct")
    public String addproduct() {
        System.out.println("addproduct.......");
        return "addproduct";
    }
    
    @PostMapping("/addprodstat")
    public String addprodstat(@ModelAttribute Product product) {
        System.out.println("addprodstat.......");
        System.out.println(product);
        
        ResponseEntity<String> response = restTemplate.postForEntity("http://Product-Microservice/products", product, String.class);
        System.out.println("Res..."+response.getBody());
        return "redirect:/products";
        
    }
    
    @RequestMapping("/editproduct")
    public String editproduct(@ModelAttribute Product product) {
        System.out.println("editproduct.......");
        return "editproduct";
    }
    
    
    
    @RequestMapping("/deleteproduct")
    public String deleteproduct(@ModelAttribute Product product) {
        System.out.println("deleteproduct.......");
        return "deleteproduct";
    }
    
    
    
    @RequestMapping("/user/{id}")
    public String deleteproduct(@PathVariable("id") String id) {
        System.out.println("deleteproduct.......");
        int x = Integer.parseInt(id);
        return "deleteproduct";
    }
    
    @RequestMapping("display")
    public String displayproduct(Model model) {
        System.out.println("hhhh.......");
        List<Product> dataList = api.fetchDataFromApi();
        
        // Add the data to the model
        model.addAttribute("apiData", dataList);
        
        return "display";
    }
    
//    @RequestMapping("displayJPA")
//    public String displayp(Model m) {
//        System.out.println("displayJPA.......");
//        List<Product> productList = productService.getByName();
//        m.addAttribute("productList",productList);
//        // Add the data to the model
//        System.out.println("*********"+productList);
//        return "dashboard";
//    }
//    
    @RequestMapping("devtool")
    @ResponseBody
    public int devtool() {
        int a = 10;
        int c = a+70;
        return c;   
    }
    
    
//    @GetMapping("/userss/{id}")
//    public List<String> demo(@PathVariable("id") int id) {
//        System.out.println("demo......."+id);
//        List<String> dataList = new ArrayList<>();
//        dataList.add("Yash");
//        
//        return dataList;
//    }
    
//    @ExceptionHandler(value = Exception.class)
//    public String numberformatHandler(Model theModel) {
//        System.out.println("Exception");        
//        theModel.addAttribute("err", "NumberFormatException");
//        return "products";
//    }
    
}