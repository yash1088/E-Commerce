package com.user.User.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "wishlist")
public class WishList {
    
    @Id
    @Column(name = "WishlistID")
    private int WishlistID;

    @Column(name = "UserID")
    private String UserID; // Changed data type to String

    @Column(name = "PId")
    private String PId; // Changed data type to String

    public WishList() {
        // Default constructor
    }

    public WishList(String userID, String pId) { // Adjusted constructor parameter types
        this.UserID = userID;
        this.PId = pId;
    }

    // Getters and setters

    public int getWishlistID() {
        return WishlistID;
    }

    public void setWishlistID(int WishlistID) {
        this.WishlistID = WishlistID;
    }

    public String getUserID() { // Adjusted return type
        return UserID;
    }

    public void setUserID(String UserID) { // Adjusted parameter type
        this.UserID = UserID;
    }

    public String getPId() { // Adjusted return type
        return PId;
    }

    public void setPId(String PId) { // Adjusted parameter type
        this.PId = PId;
    }
    
    @Override
    public String toString() {
        return "Wishlist{" +
                "WishlistID=" + WishlistID +
                ", UserID=" + UserID +
                ", PId=" + PId +
                '}';
    }
}
