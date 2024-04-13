package com.user.UserMicroService.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    
    @Id
    @Column(name = "CartID")
    private int CartID;

    @Column(name = "UserID")
    private String UserID;

    @Column(name = "PId")
    private String PId;

    @Column(name = "Quantity")
    private int Quantity;

    public Cart() {
        // Default constructor
    }

    public Cart(String userID, String pId, int quantity) {
        this.UserID = userID;
        this.PId = pId;
        this.Quantity = quantity;
    }

    // Getters and setters

    public int getCartID() {
        return CartID;
    }

    public void setCartID(int CartID) {
        this.CartID = CartID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getPId() {
        return PId;
    }

    public void setPId(String PId) {
        this.PId = PId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    
    @Override
    public String toString() {
        return "Cart{" +
                "CartID=" + CartID +
                ", UserID=" + UserID +
                ", PId=" + PId +
                ", Quantity=" + Quantity +
                '}';
    }
}
