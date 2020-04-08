package example.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import example.Person;
import example.data.PersonRepository;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class PersonControllerTest {

    @Test
    public void shouldShowAllPersons() throws Exception {
        List<Person> expectedPersons = createPersonList(20);
        PersonRepository mockRepository = mock(PersonRepository.class);
        when(mockRepository.findPersons(Long.MAX_VALUE))
                .thenReturn(expectedPersons);

        PersonController controller = new PersonController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/list.jsp"))
                .build();

        mockMvc.perform(get("/person/list"))
                .andExpect(view().name("list"))
                .andExpect(model().attributeExists("personList"))
                .andExpect(model().attribute("personList",
                        hasItems(expectedPersons.toArray())));
    }

    @Test
    public void shouldShowFilterPersons() throws Exception {
        List<Person> expectedPersons = createPersonList(50);
        PersonRepository mockRepository = mock(PersonRepository.class);
        when(mockRepository.findPersons(50))
                .thenReturn(expectedPersons);

        PersonController controller = new PersonController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/list.jsp"))
                .build();

        mockMvc.perform(get("/person/list?max=50"))
                .andExpect(view().name("list"))
                .andExpect(model().attributeExists("personList"))
                .andExpect(model().attribute("personList",
                        hasItems(expectedPersons.toArray())));
    }

    @Test
    public void testPerson() throws Exception {
        Person expectedPerson = new Person("Name", "abc", "111111", "77777777777");
        PersonRepository mockRepository = mock(PersonRepository.class);
        when(mockRepository.findByName("zhangsan")).thenReturn(expectedPerson);

        PersonController controller = new PersonController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/person/zhangsan"))
                .andExpect(view().name("person"))
                .andExpect(model().attributeExists("person"))
                .andExpect(model().attribute("person", expectedPerson));
    }

    @Test
    public void addPerson() throws Exception {
        PersonRepository mockRepository = mock(PersonRepository.class);
        PersonController controller = new PersonController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/person/add")
                .param("name", "name123")
                .param("address", "this is address")
                .param("zipCode", "123456")
                .param("phone", "12345678900"))
                .andExpect(redirectedUrl("/person/list"));

        verify(mockRepository, atLeastOnce()).save(new Person("name123", "this is address", "123456", "12345678900"));
    }

    @Test
    public void updatePerson() throws Exception {
        PersonRepository mockRepository = mock(PersonRepository.class);
        PersonController controller = new PersonController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/person/update")
                .param("name", "name123")
                .param("address", "this is address")
                .param("zipCode", "123456")
                .param("phone", "12345678900"))
                .andExpect(view().name("list"));

        verify(mockRepository, atLeastOnce()).update(new Person("name123", "this is address", "123456", "12345678900"));
    }

    @Test
    public void deletePerson() throws Exception {
        PersonRepository mockRepository = mock(PersonRepository.class);
        PersonController controller = new PersonController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/person/delete")
                .param("name", "name123"))
                .andExpect(view().name("list"));

        verify(mockRepository, atLeastOnce()).delete("name123");
    }

    private List<Person> createPersonList(int count) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            persons.add(new Person("Person " + i, "abcdefghijiadiididid", "212001", "13377777777"));
        }
        return persons;
    }
}
