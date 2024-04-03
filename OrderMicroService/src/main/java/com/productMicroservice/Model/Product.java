package com.productMicroservice.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private int id;

    @Column(name = "Name")
    @JsonProperty("name")
    private String name;

    @Column(name = "Price")
    @JsonProperty("price")
    private String price;

    @Column(name = "Category")
    @JsonProperty("category")
    private String category;

    @Column(name = "Description")
    @JsonProperty("description")
    private String description;

    
    @Column(name = "ImageURL")
    @JsonProperty("imageUrl")
    private String imageURL;
    
    @Column(name = "Rating")
    @JsonProperty("rating")
    private String rating;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
   

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public Product() {
    }

    public Product(int id, String name, String price, String category, String description, String imageURL) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.imageURL = imageURL;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", description=" + description + ", imageURL=" + imageURL + ", rating=" + rating + '}';
    }

    
}
