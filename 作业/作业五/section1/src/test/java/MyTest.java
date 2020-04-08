import com.example.config.RootConfig;
import com.example.dao.UserRepository;
import com.example.domain.User;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@WebAppConfiguration
public class MyTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void testCount(){
        assertEquals(1,userRepository.getMatchCount("admin","123456").intValue());
    }

    @Test
    @Transactional
    public void testCache(){
        assertNotNull(userRepository.findUserByUserName("admin"));
        userRepository.deleteByUserName("admin");
        assertNotNull(userRepository.findUserByUserName("admin"));
    }

    @Test
    public void testMock(){
        User u=new User(1,"admin");
        UserRepository mockRepository=mock(UserRepository.class);
        when(mockRepository.findUserByUserName("admin")).thenReturn(u);
        assertEquals(u,mockRepository.findUserByUserName("admin"));
    }

    @Test
    public void f(){
        User u=new User(1,"admin");
        UserService m=mock(UserService.class);
        when(m.findUserByUserName("admin")).thenReturn(u);
        assertEquals(m.findUserByUserName("admin"),u);
    }
}
