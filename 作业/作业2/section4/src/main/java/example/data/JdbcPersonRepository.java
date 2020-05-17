package example.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import example.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcPersonRepository implements PersonRepository {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcPersonRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

       public Person save(Person person) {
        jdbc.update(
                "insert into address_book (name, address, zip_code, phone)" +
                        " values (?, ?, ?, ?)",
                person.getName(),
                person.getAddress(),
                person.getZipCode(),
                person.getPhone());
        return person; // TODO: Determine value for id
    }

    public Person findByName(String name) {
        return jdbc.queryForObject(
                "select id, name, address, zip_code, phone from address_book where name=?",
                new PersonRowMapper(),
                name);
    }


    @Override
    public List<Person> findPersons(long max) {
        return jdbc.query(
                "select id, name, address, zip_code, phone" +
                        " from address_book" +
                        " where id <= ?",
                new PersonRowMapper(), max);
    }

    @Override
    public Person update(Person person) {
        jdbc.update(
                "update address_book set address=? ,zip_code=? ,phone=? where name=?",
                person.getAddress(),
                person.getZipCode(),
                person.getPhone(),
                person.getName());
        return person;
    }

    @Override
    public String delete(String name) {
        jdbc.update(
                "delete FROM address_book WHERE name=?",
                name
        );
        return "success";
    }

    private static class PersonRowMapper implements RowMapper<Person> {
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Person(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("zip_code"),
                    rs.getString("phone"));
        }
    }

}
