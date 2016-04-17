package com.itu.shareonwheels;

/**
 * Created by ramya on 10/2/15.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.sql.SQLException;


//@EnableWebSecurity
@SpringBootApplication
@EnableAutoConfiguration
public class ShareOnWheelsServer{// extends WebSecurityConfigurerAdapter {

    private static Log logger = LogFactory.getLog(ShareOnWheelsServer.class);

    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://54.186.236.106:3306/shareonwheels");
        dataSource.setUsername("shareonwheels");
        dataSource.setPassword("password");
        try {
            dataSource.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {

            public void contextInitialized(ServletContextEvent sce) {
                logger.info("ServletContext initialized");
            }

            public void contextDestroyed(ServletContextEvent sce) {
                logger.info("ServletContext destroyed");
            }

        };
    }

//    @Override
//   protected void configure(HttpSecurity httpSecurity) throws Exception{
//       httpSecurity.csrf().disable();
//   }


    public static void main(String[] args) {
        SpringApplication.run(ShareOnWheelsServer.class, args);
    }
}
