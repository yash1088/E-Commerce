package com.user.User.Model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "order")
public class Order {
    
    @Id
    @Column(name = "OrderID")
    private int OrderID;

    @Column(name = "UserID")
    private int UserID;

    @Column(name = "OrderDate")
    private Timestamp OrderDate;

    @Column(name = "TotalAmount")
    private double TotalAmount;

    @Column(name = "Status")
    private String Status;

    public Order() {
        // Default constructor
    }

    public Order(int userID, Timestamp orderDate, double totalAmount, String status) {
        this.UserID = userID;
        this.OrderDate = orderDate;
        this.TotalAmount = totalAmount;
        this.Status = status;
    }

    // Getters and setters

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public Timestamp getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Timestamp OrderDate) {
        this.OrderDate = OrderDate;
    }

    public double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(double TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    

    @Override
    public String toString() {
        return "Order{" +
                "OrderID=" + OrderID +
                ", UserID=" + UserID +
                ", OrderDate=" + OrderDate +
                ", TotalAmount=" + TotalAmount +
                ", Status='" + Status + '\'' +
                '}';
    }
}
