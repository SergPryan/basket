package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

//    public Order create(Order order) {
//        String sql = "INSERT INTO orders (full_name, telephone) VALUES (?, ?)";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps =
//                    connection.prepareStatement(sql, new String[]{"id"});
//            ps.setString(2, String.valueOf(order.getTelephone()));
//            ps.setString(1, order.getFullName());
//            return ps;
//        }, keyHolder);
//
//        System.out.println("key = " + keyHolder.getKey().intValue());
//        order.setId(keyHolder.getKey().longValue());
//        order.getList().forEach(element ->
//                {
//                    String insertProduct = "UPDATE product SET order_id=? WHERE id=?";
//                    jdbcTemplate.update(insertProduct, order.getId().intValue(), element.getId().intValue());
//                }
//        );
//        return order;
//    }
}
