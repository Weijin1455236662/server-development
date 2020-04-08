
package com.example.db.hibernate4;

import com.example.db.CustomerRepository;
import com.example.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Repository
public class HibernateCustomerRepository implements CustomerRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateCustomerRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public Customer save(Customer customer) {
        Serializable id = currentSession().save(customer);
        return new Customer((Long) id,
                customer.getName(),
                customer.getAddress(),
                customer.getCity(),
                customer.getEmail());
    }

    @Override
    public Customer findOne(long id) {
        return (Customer) currentSession().get(Customer.class, id);
    }

    @Override
    public Customer findByName(String name) {
        return (Customer) currentSession()
                .createCriteria(Customer.class)
                .add(Restrictions.eq("name", name))
                .list().get(0);
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) currentSession()
                .createCriteria(Customer.class).list();
    }

}
