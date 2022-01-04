package com.example.newsdatabaseapp.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatabaseConfig {

    DataSource dataSource;



    public DatabaseConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);

    }

//    @EventListener(ApplicationReadyEvent.class)
    public void initDB()
    {
        String sql = "CREATE  TABLE news (Section varchar(255), Title varchar(255), URL varchar(255))";
        getJdbcTemplate().update(sql);

    }

//    @Bean
//    public JdbcTemplate getJdbcTemplate() {
//        return new JdbcTemplate(dataSource);
//
//    }

//    NewsDaoImpl newsDao;

//    @Autowired
//    public DatabaseConfig(NewsDaoImpl newsDao) {
//        this.newsDao = newsDao;
//    }

//    DataSource dataSource;
//
//
//    public DatabaseConfig( DataSource dataSource) {
//
//        this.dataSource = dataSource;
//    }



//
//    @Bean
//    public DataSource getdataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:mysql://remotemysql.com/Xoaizfgh2D");
//        dataSourceBuilder.username("Xoaizfgh2D");
//        dataSourceBuilder.password("DNmhNeNLXn");
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//
//        return dataSourceBuilder.build();
//
//    }

//    public JdbcTemplate getJdbcTemplate() {
//        return new JdbcTemplate(getdataSource());
//    }



//        @EventListener(ApplicationReadyEvent.class)


//    @EventListener(ApplicationReadyEvent.class)
//    public void test()
//    {
//
//        String sql ="SELECT * FROM news";
//                getJdbcTemplate().update(sql);
//
//
//    }


//    public void save1(String section, String title, String url) {
//
//
//        String sql = "INSERT INTO news VALUES(?,?,?)";
//        getJdbcTemplate().update(sql, section, title, url);
//
//    }

//    public void save2(List<String> title, List<String> section, List<String> url) {
//
//
//        String sql = "INSERT INTO news VALUES(?,?,?)";
//        getJdbcTemplate().update(sql, section, title, url);
//
//    }

//    public void save3( String id,  String type,  String sectionId,  String sectionName, String webPublicationDate,  String webTitle,  String webUrl,  String apiUrl,  boolean isHosted,   String pillarId, String pillarName) {
//
//
//        String sql = "INSERT INTO news VALUES(?,?,?,?,?,?,?,?,?,?,?,)";
//        getJdbcTemplate().update(sql, section, title, url);
//
//    }



//    public List<Article> maps(String sql) {
//        List<Article> articles = new ArrayList<>();
//        List<Map<String, Object>> maps = getJdbcTemplate().queryForList(sql);
//        maps.stream().forEach(element -> articles.add(new Article(
//                String.valueOf(element.get("Section")),
//                String.valueOf(element.get("Title")),
//                String.valueOf(element.get("URL"))
//
//
//        )));
//
//        return articles;
//    }
//    public List<Article> showListOfNews() {
//
//        String sql = "SELECT *  FROM news";
//
//        return maps(sql);
//    }
//    public List<Article> maps2(String sql) {
//
//
//
//        List<Article> articles = new ArrayList<>();
//        List<Map<String, Object>> maps = getJdbcTemplate().queryForList(sql);
//        maps.stream().forEach(element -> {
////            try {
//            articles.add(new Article(
//                    String.valueOf(element.get("section")),
//                    String.valueOf(element.get("title")),
//                    String.valueOf(element.get("url"))));
//
//
//        });
//
//        return articles;
//    }


//    public List<Article>  test()
//    {
//        String sql = "SELECT * FROM news";
//
//        System.out.println(maps(sql));
//        return maps(sql);
//
//    }

//public void test() throws UnirestException, ParseException {
//    for(String s : newsDao.newsTitle())
//    {
//
//
//    }



//    @EventListener(ApplicationReadyEvent.class)
//    public void test() throws UnirestException, ParseException {
//        save2(newsDao.newsTitle(),newsDao.newsSection(), newsDao.newsURL());
//    }

//    @EventListener(ApplicationReadyEvent.class)
//    public List<Article> showListOfNews()  {
//
//        String sql = "SELECT *  FROM cars ORDER BY car_id";
//
//        return maps2(sql);
//    }

}
