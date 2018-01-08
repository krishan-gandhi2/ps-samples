package com.pupilsky.tutorials.core.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.datasource.DriverManagerDataSource;




/**
 * Created by krishan.gandhi on 20/12/2017.
 */
@Configuration
@PropertySources({
    @PropertySource("classpath:database.properties")
})
public class AppConfig {
    
    @Value("${database.datasource.url}")
    private String datasourceUrl;
    
    @Value("${database.database.driverClassName}")
    private String dbDriverClassName;
    
    @Value("${database.datasource.username}")
    private String dbUsername;
    
    @Value("${database.datasource.password}")
    private String dbPassword;
    
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName(dbDriverClassName);
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

}
