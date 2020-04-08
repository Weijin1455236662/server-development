package com.example.db.hibernate4;

import com.example.domain.Cargo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.example.db.CargoRepository;
import com.example.domain.Customer;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryTestConfig.class)
public class CargoRepositoryTest {

    @Autowired
    CargoRepository cargoRepository;

    @Test
    @Transactional
    public void count() {
        assertEquals(15, cargoRepository.count());
    }

    @Test
    @Transactional
    public void findRecent() {
        // default case
        {
            List<Cargo> recent = cargoRepository.findRecent();
            assertRecent(recent, 10);
        }

        // specific count case
        {
            List<Cargo> recent = cargoRepository.findRecent(5);
            assertRecent(recent, 5);
        }
    }

    @Test
    @Transactional
    public void findOne() {
        Cargo thirteen = cargoRepository.findOne(13);
        assertEquals(13, thirteen.getId().longValue());
        assertEquals("cargo13", thirteen.getProduct());
        assertEquals(14,thirteen.getQuantity().intValue());
        assertEquals(1332682500000L, thirteen.getOrderDate().getTime());
        assertEquals(4, thirteen.getCustomer().getId().longValue());
        assertEquals("zhaoliu", thirteen.getCustomer().getName());
        assertEquals("address4", thirteen.getCustomer().getAddress());
        assertEquals("beijing", thirteen.getCustomer().getCity());
        assertEquals("zhaoliu@163.com", thirteen.getCustomer().getEmail());
    }

    @Test
    @Transactional
    public void findByCustomer() {
        List<Cargo> cargos = cargoRepository.findByCustomerId(4L);
        assertEquals(11, cargos.size());
        for (int i = 0; i < 11; i++) {
            assertEquals(15 - i, cargos.get(i).getId().longValue());
        }
    }

    @Test
    @Transactional
    public void save() {
        assertEquals(15, cargoRepository.count());
        Customer customer = cargoRepository.findOne(13).getCustomer();
        Cargo cargo = new Cargo(null, customer, "cargo16", 3, new Date());
        Cargo saved = cargoRepository.save(cargo);
        assertEquals(16, cargoRepository.count());
        assertNewCargo(saved);
        assertNewCargo(cargoRepository.findOne(16L));
    }

    @Test
    @Transactional
    public void delete() {
        assertEquals(15, cargoRepository.count());
        assertNotNull(cargoRepository.findOne(13));
        cargoRepository.delete(13L);
        assertEquals(14, cargoRepository.count());
        assertNull(cargoRepository.findOne(13));
    }

    private void assertRecent(List<Cargo> recent, int count) {
        long[] recentIds = new long[]{3, 2, 1, 15, 14, 13, 12, 11, 10, 9};
        assertEquals(count, recent.size());
        for (int i = 0; i < count; i++) {
            assertEquals(recentIds[i], recent.get(i).getId().longValue());
        }
    }

    private void assertNewCargo(Cargo cargo) {
        assertEquals(16, cargo.getId().longValue());
    }

}
