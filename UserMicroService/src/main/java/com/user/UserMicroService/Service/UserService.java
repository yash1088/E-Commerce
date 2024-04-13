package com.user.UserMicroService.Service;


import com.user.UserMicroService.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    JdbcTemplate template;

    public int save(User user) {
        String sql = "INSERT INTO user (UserID, Username, Password, FirstName, LastName, Address, PhoneNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return template.update(sql, user.getUserID(), user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getAddress(), user.getPhoneNumber());
    }

    public int update(User user) {
        String sql = "UPDATE user SET Username=?, Password=?, FirstName=?, LastName=?, Address=?, PhoneNumber=? WHERE UserID=?";
        return template.update(sql, user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getAddress(), user.getPhoneNumber(), user.getUserID());
    }

    public int delete(String userID) {
        String sql = "DELETE FROM user WHERE UserID=?";
        return template.update(sql, userID);
    }

    public User getUserByID(String userID) {
        String sql = "SELECT * FROM user WHERE UserID=?";
        return template.queryForObject(sql, new Object[]{userID}, new BeanPropertyRowMapper<>(User.class));
    }
    
    public String checkUserExist(String userID) {
        String sql = "SELECT UserID FROM user WHERE UserID=?";
        return template.queryForObject(sql, String.class, userID);
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
