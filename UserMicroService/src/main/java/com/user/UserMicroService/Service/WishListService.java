package com.user.UserMicroService.Service;

import com.user.UserMicroService.Model.Product;
import com.user.UserMicroService.Model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishListService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addToWishList(WishList wishList) {
        String sql = "INSERT INTO wishlist (UserID, PId) VALUES (?, ?)";
        return jdbcTemplate.update(sql, wishList.getUserID(), wishList.getPId());
    }

    public int removeFromWishList(int wishlistId) {
        String sql = "DELETE FROM wishlist WHERE WishlistID = ?";
        return jdbcTemplate.update(sql, wishlistId);
    }

    public List<Product> getUserWishList(String userId) {
        String sql = "SELECT p.* FROM Wishlist w INNER JOIN products p ON w.PId = p.PId WHERE w.UserID = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(Product.class));
    }
}
