package com.example.dao;

import com.example.config.RootConfig;
import com.example.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@WebAppConfiguration
public class UserDaoTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void hasMatchUser() {
        Long count = userRepository.getMatchCount("admin", "123456");
        assertTrue(count > 0);
    }

    @Test
    public void findUserByUserName() {
        User user = userRepository.findUserByUserName("admin");
        assertNotNull(user);
        assertEquals(user.getUserName(), "admin");
    }

}
