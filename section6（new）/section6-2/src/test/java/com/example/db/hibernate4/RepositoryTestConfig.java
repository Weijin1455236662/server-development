package com.example.db.hibernate4;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan
public class RepositoryTestConfig implements TransactionManagementConfigurer {

  @Inject
  private SessionFactory sessionFactory;

  @Bean
  public DataSource dataSource() {
    EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder();
    edb.setType(EmbeddedDatabaseType.H2);
    edb.addScript("com/example/db/hibernate4/schema.sql");
    edb.addScript("com/example/db/hibernate4/test-data.sql");
    EmbeddedDatabase embeddedDatabase = edb.build();
    return embeddedDatabase;
  }

  public PlatformTransactionManager annotationDrivenTransactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory);
    return transactionManager;
  }

  @Bean
  public SessionFactory sessionFactoryBean() {
    try {
      LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
      lsfb.setDataSource(dataSource());
      lsfb.setPackagesToScan("com.example.domain");
      Properties props = new Properties();
      props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
//      props.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
      lsfb.setHibernateProperties(props);
      lsfb.afterPropertiesSet();
      SessionFactory object = lsfb.getObject();
      return object;
    } catch (IOException e) {
      return null;
    }
  }

  @Bean
  public BeanPostProcessor persistenceTranslation(){
    return new PersistenceExceptionTranslationPostProcessor();
  }
}
