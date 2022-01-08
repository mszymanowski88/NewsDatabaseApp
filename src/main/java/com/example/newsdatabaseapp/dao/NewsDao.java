package com.example.newsdatabaseapp.dao;

import com.example.newsdatabaseapp.api.Article;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface NewsDao {

  void initDB();

  void saveNews(String query) throws UnirestException;

  void deleteDatabase();

  List<Article> findAll();


}
