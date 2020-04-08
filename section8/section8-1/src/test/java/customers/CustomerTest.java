package customers;

import customers.config.MongoConfig;
import customers.db.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = MongoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void cleanup() {
        customerRepository.deleteAll();
    }

    @Test
    public void mytest1() {
        Customer customer = createAnCustomer();

        Customer savedCustomer = customerRepository.save(customer);
        System.out.println(savedCustomer);
    }

    @Test
    public void mytest2() {
        assertEquals(0, customerRepository.count());

        Customer customer = createAnCustomer();
        Customer savedCustomer = customerRepository.save(customer);

        assertEquals(1, customerRepository.count());

        Customer foundCustomer = customerRepository.findOne(savedCustomer.getId());
        assertEquals("taozs", foundCustomer.getName());
        assertEquals(2, foundCustomer.getCargos().size());

        List<Customer> likeCustomers = customerRepository.findByNameLike("tao");
        assertEquals(1,likeCustomers.size());
        assertEquals("taozs", likeCustomers.get(0).getName());
        assertEquals(2, likeCustomers.get(0).getCargos().size());

        List<Customer> nameAndCityCustomers = customerRepository.findByNameAndCity("taozs","nanjing");
        assertEquals(1,nameAndCityCustomers.size());
        assertEquals("taozs", nameAndCityCustomers.get(0).getName());
        assertEquals(2, nameAndCityCustomers.get(0).getCargos().size());

        List<Customer> noneCustomers = customerRepository.findByNameAndCity("taoz","nanjing");
        assertEquals(0,noneCustomers.size());

        List<Customer> taoCustomers = customerRepository.findTaoCustomer();
        assertEquals(1,taoCustomers.size());
        assertEquals("taozs", taoCustomers.get(0).getName());
        assertEquals(2, taoCustomers.get(0).getCargos().size());

    }

    private Customer createAnCustomer() {
        Customer customer = new Customer();
        customer.setName("taozs");
        customer.setAddress("江苏省南京市雨花区软件大道101号");
        customer.setCity("nanjing");
        customer.setEmail("tzs@163.com");


        Cargo cargo1 = new Cargo();
        cargo1.setId(1);
        cargo1.setProduct("电脑");
        cargo1.setQuantity(2);
        cargo1.setOrderDate(Date.valueOf("2019-09-19"));

        Cargo cargo2 = new Cargo();
        cargo2.setId(2);
        cargo2.setProduct("手机");
        cargo2.setQuantity(5);
        cargo2.setOrderDate(Date.valueOf("2020-03-19"));

        customer.setCargos(Arrays.asList(cargo1, cargo2));
        return customer;
    }
}
