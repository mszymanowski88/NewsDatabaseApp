package com.example.newsdatabaseapp.dao;

import com.example.newsdatabaseapp.api.Article;
import com.example.newsdatabaseapp.api.GuardianContentApi;
import com.example.newsdatabaseapp.api.Response;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class NewsDaoImpl {

//    DatabaseConfig databaseConfig;

 JdbcTemplate jdbcTemplate;
    GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");

//  DataSource dataSource;
//    DatabaseConfig databaseConfig;


    public NewsDaoImpl() {
    }

    @Autowired
    public NewsDaoImpl( JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;

    }

//    @Autowired
//    public NewsDaoImpl(DatabaseConfig databaseConfig ) {
//
//
//        this.databaseConfig = databaseConfig;
//    }

//    public NewsDaoImpl(JdbcTemplate jdbcTemplate, DataSource dataSource) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.dataSource = dataSource;
//    }


//    @Autowired
//    public NewsDaoImpl( DatabaseConfig databaseConfig) {
//        this.databaseConfig = databaseConfig;
//    }


//    public void save1(String section, String title, String url) {
//
//
//        String sql = "INSERT INTO news VALUES(?,?,?)";
//       jdbcTemplate.update(sql, section, title, url);
//
//    }


//    public void save1(String section, String title, String url) {
//
//
//        String sql = "INSERT INTO news VALUES(?,?,?)";
//        jdbcTemplate.update(sql, section, title, url);
//
//    }




//    public void saveNews() throws UnirestException, ParseException {
//
//        SimpleDateFormat s = new SimpleDateFormat();
//
//
//        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");
//
//        Response response = api.getContent("bitcoin");
//       List<Article> newlist = Arrays.stream(response.getResults()).collect(Collectors.toList());
//
//        for(Article sa :  newlist)
//        {
//            databaseConfig.save1(sa.getSectionName(), sa.getWebTitle(), sa.getWebUrl());
//
//        }



    public void initDB()
    {
        String sql = "CREATE  TABLE news (Section varchar(255), Title varchar(255), URL varchar(255))";
        jdbcTemplate.update(sql);

    }


    public boolean saveNews(String query) throws UnirestException, ParseException {

        String sql = "INSERT INTO news VALUES(?,?,?)";

        for(Article sa :  userQuery(query))
        {
            jdbcTemplate.update(sql, sa.getSectionName(), sa.getWebTitle(), sa.getWebUrl());

        }

        return true;

    }

    public boolean guardianSaveNews(String query) throws UnirestException, ParseException {

        String sql = "INSERT INTO news VALUES(?,?,?)";

        for(Article sa :  api.userQueryGuardian(query))
        {
            jdbcTemplate.update(sql, sa.getSectionName(), sa.getWebTitle(), sa.getWebUrl());

        }

        return true;

    }
    public List <Article> userQuery (String userQuery) throws UnirestException, ParseException {

//        userQuery = "Poland";
        GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");
        SimpleDateFormat s = new SimpleDateFormat();
        System.out.println(Arrays.stream(api.getContent(userQuery).getResults()).collect(Collectors.toList()));

        return Arrays.stream(api.getContent(userQuery).getResults()).collect(Collectors.toList());
    }

    public boolean saveNews1(String query) throws UnirestException, ParseException {

//        query = "bitcoin";
        GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");
        SimpleDateFormat s = new SimpleDateFormat();


        System.out.println(   Arrays.stream(api.getContent(query).getResults()).collect(Collectors.toList()));
        String sql = "INSERT INTO news VALUES(?,?,?)";

        for(Article sa :   Arrays.stream(api.getContent(query).getResults()).collect(Collectors.toList()))
        {
            jdbcTemplate.update(sql, sa.getSectionName(), sa.getWebTitle(), sa.getWebUrl());

        }

        return true;

    }



    public void deleteDatabase ()
    {



//        String sql = "DROP TABLE cars";
        System.out.println("wykonane");
        String sql = "DROP TABLE IF EXISTS news";
        System.out.println("Init");

//        String sql = "DROP TABLE news";
        jdbcTemplate.update(sql);
    }

//test
//    public Response userFrontendInput(String userInput) throws UnirestException {
//            GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");
//            return  api.getContent(userInput);
//        }
//
//
////to jest ok!
//    public List <Article> userQuery (String userQuery) throws UnirestException, ParseException {
//
////        userQuery = "Poland";
//
//        SimpleDateFormat s = new SimpleDateFormat();
//
//        return Arrays.stream(userFrontendInput(userQuery).getResults()).collect(Collectors.toList());
//    }
//    test



//    public Response userFrontendInput(String userInput) throws UnirestException {
//
//        return  api.getContent(userInput);
//    }


    //to jest ok!



//        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");

//        Response response = api.getContent(userQuery);

//        userFrontendInput(userQuery);

//        for(Article sa :  Arrays.stream(userFrontendInput(userQuery).getResults()).collect(Collectors.toList()))
//        {
//            jdbcTemplate.update(sa.getSectionName(), sa.getWebTitle(), sa.getWebUrl());
//
//        }

//        String sql = "INSERT INTO news VALUES(?,?,?)";
//        jdbcTemplate.update(sql, section, title, url);



//        System.out.println("***");
//        System.out.println( userFrontendInput(userQuery));

//        return Arrays.stream(response.getResults()).collect(Collectors.toList());

//    public Response userQuery (String userQuery) throws UnirestException, ParseException {
//
//        userQuery = "Poland";
//
//        SimpleDateFormat s = new SimpleDateFormat();
//
//
//        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");
//
//        Response response = api.getContent(userQuery);
//
//        System.out.println("***");
//        System.out.println(response);
////        saveNews(userQuery);
//        return response;
//    }


    public  Response userInput (String userQuery) throws UnirestException, ParseException {



        SimpleDateFormat s = new SimpleDateFormat();


        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");

        Response response = api.getContent("bitcoin");

        return response;
    }


    public  Response userInput1 (String userQuery) throws UnirestException, ParseException {



        SimpleDateFormat s = new SimpleDateFormat();


        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");

        Response response = api.getContent("bitcoin");

        return response;
    }

    public  List <Article> showInputNews (Response response) throws UnirestException, ParseException {



        return Arrays.stream(response.getResults()).collect(Collectors.toList());
    }

    public List<Article> maps(String sql) {
        List<Article> articles = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> articles.add(new Article(
                String.valueOf(element.get("Section")),
                String.valueOf(element.get("Title")),
                String.valueOf(element.get("URL"))


        )));

        return articles;
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

        return jdbcTemplate.query(sql, rm);
    }

    public List<Article> showListOfNews() {

        String sql = "SELECT *  FROM news";

        return maps(sql);
    }






    public Article[] newsData() throws UnirestException, ParseException
    {


        SimpleDateFormat s = new SimpleDateFormat();


        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");

        Response response = api.getContent("bitcoin");


       return response.getResults();


    }





    public Response showData() throws UnirestException, ParseException {

        SimpleDateFormat s = new SimpleDateFormat();


//        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");

        Response response = api.getContent("Ecology");

        return response;



    }


//    public Response showRequestedData(String input) throws UnirestException, ParseException {
//
//        SimpleDateFormat s = new SimpleDateFormat();
//
//
////        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        GuardianContentApi api = new GuardianContentApi("cdebde7d-5c15-4657-9f39-5e7bcb513794");
//
//        Response response = api.getContent("bitcoin");
//        List<String> newlist = Stream.of(newsSection1(),newsTitle(),newsURL()).flatMap(Collection::stream).collect(Collectors.toList());
//        for(Article sa :  newlist)
//        {
//            jdbcTemplate.update(sa.getSectionName(), sa.getWebTitle(), sa.getWebUrl());
//
//        }
//
//        return response;
//
//
//
//    }


//    @EventListener(ApplicationReadyEvent.class)
    public List<String> newsSection1() throws UnirestException, ParseException {


        return Arrays.stream(showData().getResults()).map(x -> x.getSectionName()).collect(Collectors.toList());

    }

    public List<String> newsTitle() throws UnirestException, ParseException {

        return Arrays.stream(showData().getResults()).map(x -> x.getWebTitle()).collect(Collectors.toList());

    }

    public List<String> newsURL() throws UnirestException, ParseException {

               return Arrays.stream(showData().getResults()).map(x -> x.getWebUrl()).collect(Collectors.toList());

    }

//    @EventListener(ApplicationReadyEvent.class)
    public void testt() throws UnirestException, ParseException {




//        List<String> newlist = Stream.of(newsSection1(),newsTitle(),newsURL()).flatMap(Collection::stream).collect(Collectors.toList());
//
//        for(String s : newlist)
//        {
//            System.out.println(s);
//
//        }


//        String section = new String();
//        String title = new String();
//        String url = new String();
//        for (String s : newsSection1())
//        {
//            System.out.println(s);
//            section = s;
//        }
//        for (String s : newsTitle())
//        {
//            System.out.println(s);
//            title = s;
//        }
//        for (String s : newsURL())
//        {
//            System.out.println(s);
//            url = s;
//        }
//        System.out.println("++++++++++++++");
//        System.out.println(section +title + url);

    }


//    public List<String> newsList() throws UnirestException, ParseException {
//
////      List<String> newList = Stream.concat(newsSection1().stream(),newsTitle().stream(),newsURL().stream()).collect(Collectors.toList());
//        List<String> newList =  Stream.concat(newsSection1().stream(), newsTitle().stream(), newsURL().stream()).distinct().collect(Collectors.toList());
//
//    }



    }

