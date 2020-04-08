package com.example.db.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("qa")
@ContextConfiguration(classes = JdbcConfig.class)
public class NamedJdbcTemplateTest {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    private static final String SQL_INSERT_CUSTOMER =
            "insert into customer (name, address, city, email) values (:name,:address,:city,:email)";

    @Test
//    @Transactional
    public void addCustomer() {
        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("name", "taozs");
        paramMap.put("address", "address88");
        paramMap.put("city", "nanjing");
        paramMap.put("email", "tzs@163.com");

        namedJdbcTemplate.update(SQL_INSERT_CUSTOMER, paramMap);
    }
}
