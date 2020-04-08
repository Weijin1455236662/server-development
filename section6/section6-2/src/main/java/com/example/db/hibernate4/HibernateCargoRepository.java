
package com.example.db.hibernate4;

import com.example.domain.Cargo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.example.db.CargoRepository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Repository
public class HibernateCargoRepository implements CargoRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateCargoRepository(SessionFactory sessionFactory) {
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
    public List<Cargo> findRecent() {
        return findRecent(10);
    }

    @Override
    public List<Cargo> findRecent(int count) {
        return (List<Cargo>) cargoCriteria()
                .setMaxResults(count)
                .list();
    }

    @Override
    public Cargo findOne(long id) {
        return (Cargo) currentSession().get(Cargo.class, id);
    }

    @Override
    public Cargo save(Cargo cargo) {
        Serializable id = currentSession().save(cargo);
        return new Cargo(
                (Long) id,
                cargo.getCustomer(),
                cargo.getProduct(),
                cargo.getQuantity(),
                cargo.getOrderDate());
    }

    @Override
    public List<Cargo> findByCustomerId(long customerId) {
        return cargoCriteria()
                .add(Restrictions.eq("customer.id", customerId))
                .list();
    }

    @Override
    public void delete(long id) {
        currentSession().delete(findOne(id));
    }

    @Override
    public List<Cargo> findAll() {
        return (List<Cargo>) cargoCriteria().list();
    }

    private Criteria cargoCriteria() {
        return currentSession()
                .createCriteria(Cargo.class)
                .addOrder(Order.desc("orderDate"));
    }

}
