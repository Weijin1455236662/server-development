package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import com.example.config.RootConfig.WebPackage;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.regex.Pattern;

@Configuration
@Import({DataConfig.class, CacheConfig.class})
@ComponentScan(basePackages = {"com.example"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, value = WebPackage.class)
        })
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.dao")

public class RootConfig {
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("com\\.example\\.web"));
        }
    }
}