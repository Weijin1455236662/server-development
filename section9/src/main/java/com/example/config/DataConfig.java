package com.example.config;

import com.example.db.CargoRepository;
import com.example.db.CustomerRepository;
import com.example.db.jdbc.JdbcCargoRepository;
import com.example.db.jdbc.JdbcCustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataConfig implements TransactionManagementConfigurer {

  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScripts("classpath:com/example/db/jdbc/schema.sql", "classpath:com/example/db/jdbc/test-data.sql")
            .build();
  }
  
  public PlatformTransactionManager annotationDrivenTransactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  public CustomerRepository customerRepository(JdbcTemplate jdbcTemplate) {
    return new JdbcCustomerRepository(jdbcTemplate);
  }

  @Bean
  public CargoRepository cargoRepository(JdbcTemplate jdbcTemplate) {
    return new JdbcCargoRepository(jdbcTemplate);
  }
}
