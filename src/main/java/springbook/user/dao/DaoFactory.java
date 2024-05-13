package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springbook.user.domain.User;

@Configuration
public class DaoFactory {

	@Bean
    public UserDao userDao() {    	
    	return new UserDao(setConnectionMaker());
    }
  
    public UserDao accountDao() {    	
    	return new UserDao(setConnectionMaker());
    }
    
    public UserDao messageDao() {    	
    	return new UserDao(setConnectionMaker());
    }    
    
    @Bean
    public SimpleConnectionMaker setConnectionMaker() {
    	return new NConnectionMaker();
    }

}
