package com.example.newsdatabaseapp.dao;

import com.example.newsdatabaseapp.api.Article;
import com.example.newsdatabaseapp.api.GuardianContentApi;
import com.example.newsdatabaseapp.config.DatabaseConfig;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NewsDaoImpl {



    DatabaseConfig databaseConfig;


    public NewsDaoImpl() {
    }

    @Autowired
    public NewsDaoImpl(DatabaseConfig databaseConfig) {

        this.databaseConfig = databaseConfig;

    }


    public void initDB() {
        String sql = "CREATE  TABLE news (Section varchar(255), Title varchar(255), URL varchar(255))";
        databaseConfig.getJdbcTemplate().update(sql);

    }


    public void saveNews(String query) throws UnirestException {


        GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");


        String sql = "INSERT INTO news VALUES(?,?,?)";

        for (Article sa : Arrays.stream(api.getContent(query).getResults()).collect(Collectors.toList())) {
            databaseConfig.getJdbcTemplate().update(sql, sa.getSectionName(), sa.getWebTitle(), sa.getWebUrl());

        }

    }


    public void deleteDatabase() {


        String sql = "DROP TABLE IF EXISTS news";

        databaseConfig.getJdbcTemplate().update(sql);
    }


    public List<Article> findAll() {
        String sql = "select * from news";
        RowMapper<Article> rm = new RowMapper<Article>() {
            @Override
            public Article mapRow(ResultSet resultSet, int i) throws SQLException {
                Article user = new Article(
                        resultSet.getString("Section"),
                        resultSet.getString("Title"),
                        resultSet.getString("URL"));


                return user;
            }

        };

        return   databaseConfig.getJdbcTemplate().query(sql, rm);
    }


}

