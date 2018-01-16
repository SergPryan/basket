package com.example.repository;

import com.example.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAll(){
       final String sql = "SELECT * FROM product WHERE order_id is NULL";
       List<Product> result = jdbcTemplate.query(sql, (resultSet, i) -> {
           Product product = new Product();
           product.setId(resultSet.getLong("id"));
           product.setName(resultSet.getString("name"));
           product.setPrice(resultSet.getFloat("price"));
           return product;
       });
       return result;

    }

}
