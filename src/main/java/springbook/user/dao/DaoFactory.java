package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class DaoFactory {

	// 팩토리의 메소드는 UserDao 타입의 오브젝트를 어떻게 만들고 준비시킬지 결정한다.
    public UserDao userDao() {    	
    	return new UserDao(setConnectionMaker());
    }
  
    public UserDao accountDao() {    	
    	return new UserDao(setConnectionMaker());
    }
    
    public UserDao messageDao() {    	
    	return new UserDao(setConnectionMaker());
    }    
    
    public SimpleConnectionMaker setConnectionMaker() {
    	return new NConnectionMaker();
    }

}
