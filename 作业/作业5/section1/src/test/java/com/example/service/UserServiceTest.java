package com.example.service;

import com.example.config.RootConfig;
import com.example.dao.LoginLogRepository;
import com.example.dao.UserRepository;
import com.example.domain.LoginLog;
import com.example.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@WebAppConfiguration
public class UserServiceTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void hasMatchUser() {
        UserRepository mockRepository=mock(UserRepository.class);
        UserService userService=new UserService();
        userService.setUserRepository(mockRepository);

        when(mockRepository.getMatchCount("admin","123456")).thenReturn((long)1);
        assertTrue(userService.hasMatcher("admin","123456"));
        assertFalse(userService.hasMatcher("admin","111111"));
    }

    @Test
    public void findUserByUserName() {
        UserRepository mockRepository=mock(UserRepository.class);
        UserService userService=new UserService();
        userService.setUserRepository(mockRepository);

        when(mockRepository.findUserByUserName("admin")).thenReturn(new User("admin"));
        assertEquals("admin",userService.findUserByUserName("admin").getUserName());
    }

    @Test
    public void loginSuccess() {
        UserRepository mockUserRepository=mock(UserRepository.class);
        LoginLogRepository mockLoginLogRepository=mock(LoginLogRepository.class);
        UserService userService=new UserService();
        userService.setUserRepository(mockUserRepository);
        userService.setLoginLogRepository(mockLoginLogRepository);

        User user=new User(1,"admin","192.168.12.7",new Date());
        LoginLog loginLog=new LoginLog(1,"192.168.12.7",user.getLastVisit());

        when(mockLoginLogRepository.save(any(LoginLog.class))).thenReturn(loginLog);
        assertEquals(loginLog,userService.saveLog(user));
    }
}
