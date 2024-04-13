/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.UserMicroService.Controller;

import com.user.UserMicroService.Model.Cart;
import com.user.UserMicroService.Model.Product;
import com.user.UserMicroService.Model.User;
import com.user.UserMicroService.Model.WishList;
import com.user.UserMicroService.Service.CartService;
import com.user.UserMicroService.Service.UserService;
import com.user.UserMicroService.Service.WishListService;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yash
 */
@RestController
public class UserMicroController {

    @Autowired
    UserService userservice;
    
    @Autowired
    WishListService wishlistservice;
    
    @Autowired
    CartService cartservice;

    @GetMapping("/data")
    public String getMsg() {
        System.out.println("data");
        return "UserMicro";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        System.out.println(user);
        String successMessage = "";
        try {
            int result = userservice.save(user);
            if (result == 1) {
                successMessage = "Product added";
            } else {
                successMessage = "Error..";
            }
        } catch (Exception ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) {
                successMessage = "Duplicate entry";
            } else {
                successMessage = "Error...";
            }
        }

        return successMessage;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        System.out.println(user);
        String successMessage = "";
        try {
            User actual = userservice.getUserByID(user.getUserID());

            if (actual.getUserID().equals(user.getUserID()) && actual.getPassword().equals(user.getPassword())) {
                successMessage = "Valid User";
            } else {
                successMessage = "Not Valid";
            }
        } catch (Exception ex) {
            if (ex instanceof EmptyResultDataAccessException) {
                successMessage = "Not Exist";
            } else {
                successMessage = "Something went wrong";
            }
        }

        return successMessage;
    }
    
    @PostMapping("/wishlist/{userId}/{productId}")
    public String wishlist(@PathVariable("userId") String userId, @PathVariable("productId") String productId, @RequestBody WishList wishlist) {
        System.out.println("data"+userId+" "+productId+" "+wishlist);
        
        String successMessage = "";
        try {
            int result = wishlistservice.addToWishList(wishlist);
            if (result == 1) {
                successMessage = "Product added";
            } else {
                successMessage = "Error..";
            }
        } catch (Exception ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) {
                successMessage = "Duplicate entry";
            } else if(ex instanceof DuplicateKeyException){
                System.out.println(ex);
                successMessage = "Duplicate entry";
            }
            else{
                successMessage = "Can`t connect to database";
            }
        }
        return successMessage;
    }

    @GetMapping("/fetchwishlistdata/{userId}")
    public List<Product> getWishListData(@PathVariable("userId") String userId){
        System.out.println("data"+userId);
        List<Product> listproduct = wishlistservice.getUserWishList(userId);
        return listproduct;
    }
    
    @PostMapping("/cart/{userId}/{productId}")
    public String cart(@PathVariable("userId") String userId, @PathVariable("productId") String productId, @RequestBody Cart cart) {
        System.out.println("lldata"+userId+" "+productId+" "+cart);
        
        String successMessage = "";
        try {
            int result = cartservice.save(cart);
            if (result == 1) {
                successMessage = "Product added";
            } else {
                successMessage = "Error..";
            }
        } catch (Exception ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) {
                successMessage = "Duplicate entry";
            } else if(ex instanceof DuplicateKeyException){
                System.out.println(ex);
                successMessage = "Duplicate entry";
            }
            else{
                successMessage = "Can`t connect to database";
            }
        }
        return successMessage;
    }
    
    @GetMapping("/fetchcartdata/{userId}")
    public List<Product> getCartData(@PathVariable("userId") String userId){
        List<Product> listproduct = cartservice.getUserCartProduct(userId);
        List<Cart> cart = cartservice.getUserCart(userId);
        for(int i=0;i<listproduct.size();i++){
            if(listproduct.get(i).getPid().equals(cart.get(i).getPId())){
                listproduct.get(i).setQuantity(cart.get(i).getQuantity());
            }
        }
        return listproduct;
    }
    
    @PostMapping("/cartitemremove/{userId}/{productId}")
    public String cartitemremove(@PathVariable("userId") String userId, @PathVariable("productId") String productId) {
        System.out.println("data"+userId+" "+productId);
        String successMessage = "";
        try {
            int result = cartservice.delete(productId);
            if (result == 1) {
                successMessage = "Item Removed..";
            } else {
                successMessage = "Error..";
            }
        } catch (Exception ex) {
                successMessage = "Can`t connect to database";
        }
        return successMessage;
    }
    
}
