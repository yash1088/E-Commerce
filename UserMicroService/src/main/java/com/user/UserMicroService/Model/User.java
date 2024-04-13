package com.user.UserMicroService.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @Column(name = "UserID")
    private String UserID;

    @Column(name = "Username")
    private String Username;

    @Column(name = "Password")
    private String Password;

    @Column(name = "FirstName")
    private String FirstName;

    @Column(name = "LastName")
    private String LastName;

    @Column(name = "Address")
    private String Address;

    @Column(name = "PhoneNumber")
    private String PhoneNumber;

    public User() {
    }

    public User(String UserID, String Username, String Password, String FirstName, String LastName, String Address, String PhoneNumber) {
        this.UserID = UserID;
        this.Username = Username;
        this.Password = Password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    @Override
    public String toString() {
        return "User{" + "UserID=" + UserID + ", Username=" + Username + ", Password=" + Password + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Address=" + Address + ", PhoneNumber=" + PhoneNumber + '}';
    }

}
