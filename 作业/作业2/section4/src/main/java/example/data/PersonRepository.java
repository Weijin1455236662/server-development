package example.data;

import example.Person;

import java.util.List;

public interface PersonRepository {
    Person save(Person person);

    Person findByName(String name);

    List<Person> findPersons(long max);

    Person update(Person person);

    String delete(String name);
}
