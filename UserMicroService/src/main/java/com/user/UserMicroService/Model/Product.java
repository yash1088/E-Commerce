package com.user.UserMicroService.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private int id;
    
    @Column(name = "pid")
    @JsonProperty("pid")
    private String pid;

    @Column(name = "Name")
    @JsonProperty("name")
    private String name;

    @Column(name = "Price")
    @JsonProperty("price")
    private double price;

    @Column(name = "Category")
    @JsonProperty("category")
    private String category;

    @Column(name = "Description")
    @JsonProperty("description")
    private String description;

    @Column(name = "ImageURL")
    @JsonProperty("imageUrl")
    private String imageUrl;

    @Column(name = "Rating")
    @JsonProperty("rating")
    private double rating;

    @Column(name = "Time")
    @JsonProperty("time")
    private String time;

    @Column(name = "Quantity")
    @JsonProperty("quantity")
    private int quantity;
    
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product() {
    }

    public Product(String pid, int id, String name, double price, String category, String description, String imageUrl, double rating, String time, int quantity) {
        this.pid = pid;
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.time = time;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "pid=" + pid + ", id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", description=" + description + ", imageUrl=" + imageUrl + ", rating=" + rating + ", time=" + time + ", quantity=" + quantity + '}';
    }

}
