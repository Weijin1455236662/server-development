package com.example.db;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.example.domain.Customer;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    @Transactional
    public void count() {
        assertEquals(4, customerRepository.count());
    }

    @Test
    @Transactional
    public void findAll() {
        List<Customer> customers = customerRepository.findAll();
        assertEquals(4, customers.size());
        assertCustomer(0, customers.get(0));
        assertCustomer(1, customers.get(1));
        assertCustomer(2, customers.get(2));
        assertCustomer(3, customers.get(3));
    }

    @Test
    @Transactional
    public void findByName() {
        assertCustomer(0, customerRepository.findByName("zhangsan"));
        assertCustomer(1, customerRepository.findByName("lisi"));
        assertCustomer(2, customerRepository.findByName("wangwu"));
        assertCustomer(3, customerRepository.findByName("zhaoliu"));
    }

    @Test
    @Transactional
    public void findOne() {
        assertCustomer(0, customerRepository.findOne(1L));
        assertCustomer(1, customerRepository.findOne(2L));
        assertCustomer(2, customerRepository.findOne(3L));
        assertCustomer(3, customerRepository.findOne(4L));
    }

    @Test
    @Transactional
    public void save_newCustomer() {
        assertEquals(4, customerRepository.count());
        Customer customer = new Customer(null, "zhaosi", "address5", "nanjing",
                "zhaosi@163.com");
        Customer saved = customerRepository.save(customer);
        assertEquals(5, customerRepository.count());
        assertCustomer(4, saved);
        assertCustomer(4, customerRepository.findOne(5L));
    }

    private static void assertCustomer(int expectedCustomerIndex, Customer actual) {
        Customer expected = CUSTOMERS[expectedCustomerIndex];
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getAddress(), actual.getAddress());
        assertEquals(expected.getCity(), actual.getCity());
        assertEquals(expected.getEmail(), actual.getEmail());
    }

    private static Customer[] CUSTOMERS = new Customer[6];

    @BeforeClass
    public static void before() {
        CUSTOMERS[0] = new Customer(1L, "zhangsan", "address1", "nanjing",
                "zhangsan@163.com");
        CUSTOMERS[1] = new Customer(2L, "lisi", "address2", "guangzhou",
                "lisi@163.com");
        CUSTOMERS[2] = new Customer(3L, "wangwu", "address3", "shanghai",
                "wangwu@163.com");
        CUSTOMERS[3] = new Customer(4L, "zhaoliu", "address4", "beijing",
                "zhaoliu@163.com");
        CUSTOMERS[4] = new Customer(5L, "zhaosi", "address5", "nanjing",
                "zhaosi@163.com");
    }
}
