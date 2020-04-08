package com.example.db.jdbc;

import com.example.db.CargoRepository;
import com.example.domain.Cargo;
import com.example.domain.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcCargoRepository implements CargoRepository {

    private static final String SELECT_CARGO = "select cg.id, c.id as customerId, c.name, c.address, c.city, c.email, cg.product, cg.quantity, cg.orderDate from Cargo cg, Customer c where cg.customer = c.id";
    private static final String SELECT_CARGO_BY_ID = SELECT_CARGO + " and cg.id=?";
    private static final String SELECT_CARGOES_BY_CUSTOMER_ID = SELECT_CARGO + " and c.id=? order by cg.orderDate desc";
    private static final String SELECT_RECENT_CARGOES = SELECT_CARGO + " order by cg.orderDate desc limit ?";

    private JdbcTemplate jdbcTemplate;

    public JdbcCargoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long count() {
        return jdbcTemplate.queryForObject("select count(id) from Cargo", Long.class);
    }

    public List<Cargo> findRecent() {
        return findRecent(10);
    }

    public List<Cargo> findRecent(int count) {
        return jdbcTemplate.query(SELECT_RECENT_CARGOES, new CargoRowMapper(), count);
    }

    public Cargo findOne(long id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CARGO_BY_ID, new CargoRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Cargo> findByCustomerId(long customerId) {
        return jdbcTemplate.query(SELECT_CARGOES_BY_CUSTOMER_ID, new CargoRowMapper(), customerId);
    }

    public Cargo save(Cargo cargo) {
        long cargoId = insertCargoAndReturnId(cargo);
        return new Cargo(cargoId, cargo.getCustomer(), cargo.getProduct(), cargo.getQuantity(), cargo.getOrderDate());
    }

    private long insertCargoAndReturnId(Cargo cargo) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Cargo");
        jdbcInsert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<>();
        args.put("customer", cargo.getCustomer().getId());
        args.put("product", cargo.getProduct());
        args.put("quantity", cargo.getQuantity());
        args.put("orderDate", cargo.getOrderDate());
        long cargoId = jdbcInsert.executeAndReturnKey(args).longValue();
        return cargoId;
    }

    public void delete(long id) {
        jdbcTemplate.update("delete from cargo where id=?", id);
    }

    @Override
    public List<Cargo> findAll() {
        return null;
    }

    private static final class CargoRowMapper implements RowMapper<Cargo> {
        public Cargo mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String product = rs.getString("product");
            int quantity = rs.getInt("quantity");
            Date orderDate = rs.getTimestamp("orderDate");
            long customerId = rs.getLong("customerId");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String city = rs.getString("city");
            String email = rs.getString("email");
            Customer customer = new Customer(customerId, name, address, city, email);
            return new Cargo(id, customer, product, quantity, orderDate);
        }
    }

}
