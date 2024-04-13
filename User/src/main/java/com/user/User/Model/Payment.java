package com.user.User.Model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "payment")
public class Payment {
    
    @Id
    @Column(name = "PaymentID")
    private int PaymentID;

    @Column(name = "OrderID")
    private int OrderID;

    @Column(name = "PaymentDate")
    private Timestamp PaymentDate;

    @Column(name = "Amount")
    private double Amount;

    @Column(name = "PaymentMethod")
    private String PaymentMethod;

    @Column(name = "PaymentStatus")
    private String PaymentStatus;

    public Payment() {
        // Default constructor
    }

    public Payment(int orderID, Timestamp paymentDate, double amount, String paymentMethod, String paymentStatus) {
        this.OrderID = orderID;
        this.PaymentDate = paymentDate;
        this.Amount = amount;
        this.PaymentMethod = paymentMethod;
        this.PaymentStatus = paymentStatus;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public Timestamp getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Timestamp PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String PaymentStatus) {
        this.PaymentStatus = PaymentStatus;
    }

    

    @Override
    public String toString() {
        return "Payment{" +
                "PaymentID=" + PaymentID +
                ", OrderID=" + OrderID +
                ", PaymentDate=" + PaymentDate +
                ", Amount=" + Amount +
                ", PaymentMethod='" + PaymentMethod + '\'' +
                ", PaymentStatus='" + PaymentStatus + '\'' +
                '}';
    }
}
