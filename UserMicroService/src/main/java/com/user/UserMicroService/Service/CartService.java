package com.user.UserMicroService.Service;

import com.user.UserMicroService.Model.Cart;
import com.user.UserMicroService.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    JdbcTemplate template;

    public int save(Cart cart) {
        String sql = "INSERT INTO cart (UserID, PId, Quantity) VALUES (?, ?, ?)";
        return template.update(sql, cart.getUserID(), cart.getPId(), cart.getQuantity());
    }

    public int update(Cart cart) {
        String sql = "UPDATE cart SET UserID=?, PId=?, Quantity=? WHERE CartID=?";
        return template.update(sql, cart.getUserID(), cart.getPId(), cart.getQuantity(), cart.getCartID());
    }

    public int delete(String pid) {
        String sql = "DELETE FROM cart WHERE Pid=?";
        return template.update(sql, pid);
    }

    public Cart getCartByID(int cartID) {
        String sql = "SELECT * FROM cart WHERE CartID=?";
        return template.queryForObject(sql, new Object[]{cartID}, new BeanPropertyRowMapper<>(Cart.class));
    }

    public List<Cart> getAllCarts() {
        String sql = "SELECT * FROM cart";
        return template.query(sql, new BeanPropertyRowMapper<>(Cart.class));
    }
    
    public List<Product> getUserCartProduct(String userId) {
        String sql = "SELECT p.* FROM cart c INNER JOIN products p ON c.PId = p.PId WHERE c.UserID = ?";
        return template.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(Product.class));
    }
    
    public List<Cart> getUserCart(String userId) {
        String sql = "SELECT c.* FROM cart c INNER JOIN products p ON c.PId = p.PId WHERE c.UserID = ?";
        return template.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(Cart.class));
    }
}
