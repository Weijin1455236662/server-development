package com.example.db.jdbc;

import com.example.db.CustomerRepository;
import com.example.domain.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcCustomerRepository implements CustomerRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcCustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long count() {
        return jdbcTemplate.queryForObject("select count(id) from customer", Long.class);
    }

    public Customer save(Customer customer) {
        Long id = customer.getId();
        if (id == null) {
            long customerId = insertCustomerAndReturnId(customer);
            return new Customer(customerId, customer.getName(), customer.getAddress(), customer.getCity(), customer.getEmail());
        } else {
            jdbcTemplate.update("update customer set name=?, address=?, city=?, email=? where id=?",
                    customer.getName(),
                    customer.getAddress(),
                    customer.getCity(),
                    customer.getEmail(),
                    id);
        }
        return customer;
    }

    private long insertCustomerAndReturnId(Customer customer) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("customer");
        jdbcInsert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<>();
        args.put("name", customer.getName());
        args.put("address", customer.getAddress());
        args.put("city", customer.getCity());
        args.put("email", customer.getEmail());
        long customerId = jdbcInsert.executeAndReturnKey(args).longValue();
        return customerId;
    }


    @SuppressWarnings("unused")
    private void insertCustomer(Customer customer) {
        jdbcTemplate.update(INSERT_CUSTOMER,
                customer.getName(),
                customer.getAddress(),
                customer.getCity(),
                customer.getEmail());
    }

    public Customer findOne(long id) {
//	return jdbcTemplate.queryForObject(
//			SELECT_CUSTOMER + " where id=?", new CustomerRowMapper(), id);
        return jdbcTemplate.queryForObject(
                SELECT_CUSTOMER + " where id=?", this::mapCustomer, id);
    }

    public Customer findByName(String name) {
        return jdbcTemplate.queryForObject("select id, name, address, city, email from Customer where name=?", new CustomerRowMapper(), name);
    }

    public List<Customer> findAll() {
        return jdbcTemplate.query("select id, name, address, city, email from Customer order by id", new CustomerRowMapper());
    }

    private static final class CustomerRowMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String city = rs.getString("city");
            String email = rs.getString("email");
            return new Customer(id, name, address, city, email);
        }
    }

    public Customer mapCustomer(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        String address = rs.getString("address");
        String city = rs.getString("city");
        String email = rs.getString("email");
        return new Customer(id, name, address, city, email);
    }

    private static final String INSERT_CUSTOMER = "insert into Customer (name, address, city, email) values (?, ?, ?, ?)";

    private static final String SELECT_CUSTOMER = "select id, name, address, city, email from Customer";

}
