package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class NConnectionMaker implements SimpleConnectionMaker{

	@Override
	public Connection makeConnection() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/toby_spring", "root", "0389");   	
    	return connection;
    }

}
