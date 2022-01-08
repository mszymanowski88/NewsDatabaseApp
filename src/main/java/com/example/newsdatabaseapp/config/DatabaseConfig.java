package com.example.newsdatabaseapp.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatabaseConfig {

    private DataSource dataSource;


    public DatabaseConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);

    }


}
