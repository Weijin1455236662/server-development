package com.example.db.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("qa")
@ContextConfiguration(classes = JdbcConfig.class)
public class originalJdbcTest {

    @Autowired
    private DataSource dataSource;

    private static final String SQL_INSERT_CUSTOMER =
            "insert into customer (name, address, city, email) values (?,?,?,?)";

    @Test
    public void addCustomer() {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_CUSTOMER);

            stmt.setString(1, "taozs");
            stmt.setString(2, "address88");
            stmt.setString(3, "nanjing");
            stmt.setString(4, "tzs@163.com");

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
