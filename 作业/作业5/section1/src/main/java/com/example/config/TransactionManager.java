package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class TransactionManager {
    @Bean(name = "transactionManager")
    public PlatformTransactionManager createTransactionManager(DataSource source){
        return new DataSourceTransactionManager(source);
    }
}
