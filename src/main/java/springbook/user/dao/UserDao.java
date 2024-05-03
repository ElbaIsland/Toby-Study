package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {
	
	private SimpleConnectionMaker connectionMaker;
	

	public UserDao(SimpleConnectionMaker connectionMaker) {		
		this.connectionMaker = connectionMaker;
	}	
	

    public void add(User user) throws ClassNotFoundException, SQLException {
    	
    	Connection connection = connectionMaker.makeConnection();
    	
        String sql = "insert into User(ID, PASSWORD, USER_NAME) values(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getuserName());

        preparedStatement.executeUpdate();

    }
    
    public void delete(User user) throws ClassNotFoundException, SQLException {

    	Connection connection = connectionMaker.makeConnection();
    	
        String sql = "delete from User where ID = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getId());

        preparedStatement.executeUpdate();

    }    

    public User get(String id) throws ClassNotFoundException, SQLException {

    	Connection connection = connectionMaker.makeConnection();
    	
        String sql = "select ID, PASSWORD, USER_NAME from User where id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        
        User user = new User();
        user.setId(rs.getString("ID"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setuserName(rs.getString("USER_NAME"));

        rs.close();
        preparedStatement.close();
        connection.close();
        
        return user;
        
    }

}
