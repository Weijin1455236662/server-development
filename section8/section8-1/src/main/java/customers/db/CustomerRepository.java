package customers.db;

import customers.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findByName(String name);

    List<Customer> findByNameLike(String name);

    List<Customer> findByNameAndCity(String name, String city);

    List<Customer> getByCity(String city);

    @Query("{email:'tzs@163.com'}")
    List<Customer> findTaoCustomer();

}
