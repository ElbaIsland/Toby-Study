package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class SimpleConnectionMaker {

    public Connection makeNewConnection() throws SQLException, ClassNotFoundException {
    	
    	// 연결 분리작업
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/toby_spring", "root", "0389");   	
    	return connection;
    }

}
