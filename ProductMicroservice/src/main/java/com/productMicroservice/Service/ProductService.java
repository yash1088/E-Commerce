package com.productMicroservice.Service;


import com.productMicroservice.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    JdbcTemplate template;

    public int save(Product p) {
        String sql = "insert into products(PId, Name, Price, Category, Description, ImageURL, Rating, Time, Quantity) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return template.update(sql, p.getPid(), p.getName(), p.getPrice(), p.getCategory(), p.getDescription(), p.getImageUrl(), p.getRating(), new Timestamp(System.currentTimeMillis()), p.getQuantity());
    }

    public int update(Product p) {
        String sql = "update products set Name=?, Price=?, Category=?, Description=?, ImageURL=?, Rating=?, Time=?, Quantity=? where PId=?";
        return template.update(sql, p.getName(), p.getPrice(), p.getCategory(), p.getDescription(), p.getImageUrl(), p.getRating(), new Timestamp(System.currentTimeMillis()), p.getQuantity(), p.getPid());
    }

    public int delete(int PId) {
        String sql = "delete from products where PId=?";
        return template.update(sql, PId);
    }

    public Product getProductById(int id) {
        String sql = "select * from products where PId=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getProduct() {
        String sql = "select * from products";
        return template.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
}
