/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springBoot.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Yash
 */

@Entity  
@Table(name = "products")
public class Product {
    
    @Id
    @Column(name = "id")
    private int Id;
    
    @Column(name = "Name")
    private String Name;
    
    @Column(name = "Price")
    private String Price;
    
    @Column(name = "Category")
    private String Category;
    
    @Column(name = "Description")
    private String Description;
    
    @Column(name = "ImageURL")
    @JsonProperty("imageUrl")
    private String ImageURL;
    
    @Column(name = "Rating")
    private String Rating;

    public String getImageURL() {
        return ImageURL;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String Rating) {
        this.Rating = Rating;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Product() {
    }

    public Product(int Id, String Name, String Price, String Category, String Description, String ImageURL, String Rating) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.Category = Category;
        this.Description = Description;
        this.ImageURL = ImageURL;
        this.Rating = Rating;
    }

    @Override
    public String toString() {
        return "Product{" + "Id=" + Id + ", Name=" + Name + ", Price=" + Price + ", Category=" + Category + ", Description=" + Description + ", ImageURL=" + ImageURL + ", Rating=" + Rating + '}';
    }

    
   
}
