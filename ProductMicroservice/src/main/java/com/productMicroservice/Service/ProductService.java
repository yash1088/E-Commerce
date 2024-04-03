/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.productMicroservice.Service;

import com.productMicroservice.Model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yash
 */

@Service
public class ProductService {
    
    @Autowired
    JdbcTemplate template;

    public int save(Product p) {
        String sql = "insert into products(Name, Price, Category, Description, ImageURL, Rating) values(?, ?, ?, ?, ?, ?)";
        return template.update(sql, p.getName(), p.getPrice(), p.getCategory(), p.getDescription(), p.getImageURL(), p.getRating());

    }

    public int update(Product p) {
        String sql = "update products set Name='" + p.getName() + "', Price=" + p.getPrice()+ ",Category='" + p.getCategory()+ "' where id=" + p.getId() + "";
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "delete from products where id=" + id + "";
        return template.update(sql);
    }

//    public Product getProductById(int id) {
//        String sql = "select * from products where id=?";
//        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Product>(Product.class));
//    }

    public List<Product> getProduct() {
        return template.query("select * from products", new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int row) throws SQLException {
                Product e = new Product();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPrice(rs.getString(3));
                e.setCategory(rs.getString(4));
                e.setDescription(rs.getString(5));
                e.setImageURL(rs.getString(6));
                e.setRating(rs.getString(7));
                return e;
            }
        });
    }
}
