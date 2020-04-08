package cargo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class CargoTest {

    @Autowired
    private RedisConnectionFactory cf;

    @Autowired
    private RedisTemplate<Integer, Cargo> redis;

    @Before
    public void cleanUp() {
        redis.delete(1);
        redis.delete(10);
        redis.delete(11);
        redis.delete(12);
        redis.delete(13);
    }

    //ValueOperations接口
    @Test
    public void workingWithSimpleValues() {
        Cargo cargo1 = new Cargo();
        cargo1.setId(1);
        cargo1.setProduct("computer");
        cargo1.setQuantity(2);
        cargo1.setOrderDate(Date.valueOf("2019-09-19"));

        redis.opsForValue().set(cargo1.getId(), cargo1);

        Cargo found = redis.opsForValue().get(cargo1.getId());
        assertEquals(cargo1.getProduct(), found.getProduct());
        assertEquals(cargo1.getQuantity(), found.getQuantity());
        assertEquals(cargo1.getOrderDate(), found.getOrderDate());
    }

    //ListOperations
    @Test
    public void workingWithLists() {
        Cargo cargo1 = new Cargo();
        cargo1.setId(1);
        cargo1.setProduct("computer");
        cargo1.setQuantity(2);
        cargo1.setOrderDate(Date.valueOf("2019-09-19"));

        Cargo cargo2 = new Cargo();
        cargo2.setId(2);
        cargo2.setProduct("phone");
        cargo2.setQuantity(4);
        cargo2.setOrderDate(Date.valueOf("2012-10-11"));

        Cargo cargo3 = new Cargo();
        cargo3.setId(3);
        cargo3.setProduct("ipad");
        cargo3.setQuantity(6);
        cargo3.setOrderDate(Date.valueOf("2020-03-18"));

        redis.opsForList().rightPush(10, cargo1);
        redis.opsForList().rightPush(10, cargo2);
        redis.opsForList().rightPush(10, cargo3);

        assertEquals(3, redis.opsForList().size(10).longValue());
    }

    @Test
    public void workingWithLists_range() {
        for (int i = 0; i < 30; i++) {
            Cargo cargo = new Cargo();
            cargo.setId(i);
            cargo.setProduct("phone-" + i);
            cargo.setQuantity(2 * i);
            cargo.setOrderDate(Date.valueOf("2012-10-11"));
            redis.opsForList().rightPush(11, cargo);
        }

        assertEquals(30, redis.opsForList().size(11).longValue());

        List<Cargo> cargos = redis.opsForList().range(11, 2, 12);
        for (int i = 0; i < cargos.size(); i++) {
            Cargo cargo = cargos.get(i);
            assertEquals("phone-" + (i + 2), cargo.getProduct());
            assertEquals((i + 2) * 2, (int) cargo.getQuantity());
        }
    }

    //SetOperations
    @Test
    public void performingOperationsOnSets() {
        Cargo cargo1 = new Cargo();
        cargo1.setId(1);
        cargo1.setProduct("computer");
        cargo1.setQuantity(2);
        cargo1.setOrderDate(Date.valueOf("2019-09-19"));

        redis.opsForSet().add(12, cargo1);
        assertEquals(1, redis.opsForSet().size(12).longValue());
    }

    //BoundListOperations
    @Test
    public void bindingToAKey() {
        Cargo cargo1 = new Cargo();
        cargo1.setId(1);
        cargo1.setProduct("computer");
        cargo1.setQuantity(2);
        cargo1.setOrderDate(Date.valueOf("2019-09-19"));

        Cargo cargo2 = new Cargo();
        cargo2.setId(2);
        cargo2.setProduct("phone");
        cargo2.setQuantity(4);
        cargo2.setOrderDate(Date.valueOf("2012-10-11"));

        Cargo cargo3 = new Cargo();
        cargo3.setId(3);
        cargo3.setProduct("ipad");
        cargo3.setQuantity(6);
        cargo3.setOrderDate(Date.valueOf("2020-03-18"));

        BoundListOperations<Integer, Cargo> cargos = redis.boundListOps(13);
        cargos.rightPush(cargo1);
        cargos.rightPush(cargo2);
        cargos.rightPush(cargo3);

        assertEquals(3, cargos.size().longValue());

        Cargo first = cargos.leftPop();
        Cargo last = cargos.rightPop();

        assertEquals(cargo1.getProduct(), first.getProduct());
        assertEquals(cargo1.getQuantity(), first.getQuantity());
        assertEquals(cargo1.getOrderDate(), first.getOrderDate());

        assertEquals(cargo3.getProduct(), last.getProduct());
        assertEquals(cargo3.getQuantity(), last.getQuantity());
        assertEquals(cargo3.getOrderDate(), last.getOrderDate());

        assertEquals(1, cargos.size().longValue());
    }

    @Test
    public void settingKeyAndValueSerializers() {
        RedisTemplate<String, Cargo> redis = new RedisTemplate();
        redis.setConnectionFactory(cf);
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new Jackson2JsonRedisSerializer<>(Cargo.class));
        redis.afterPropertiesSet();

        Cargo cargo1 = new Cargo();
        cargo1.setId(1);
        cargo1.setProduct("computer");
        cargo1.setQuantity(2);
        cargo1.setOrderDate(Date.valueOf("2019-09-19"));

        redis.opsForValue().set(cargo1.getId().toString(), cargo1);

        Cargo found = redis.opsForValue().get(cargo1.getId().toString());
        assertEquals(cargo1.getProduct(), found.getProduct());
        assertEquals(cargo1.getQuantity(), found.getQuantity());

		StringRedisTemplate stringRedis = new StringRedisTemplate(cf);
		String json = stringRedis.opsForValue().get(cargo1.getId().toString());
		assertEquals("{\"id\":1,\"product\":\"computer\",\"quantity\":2,\"orderDate\":\"2019-09-19\"}", json);

    }
}
