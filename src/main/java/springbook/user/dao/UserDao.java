package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.User;

public class UserDao {

    public void add(User user) throws ClassNotFoundException, SQLException {
    	
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "spring", "book");
    	
        String sql = "insert into users(ID, PASSWORD, USER_NAME) values(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getuserName());

        preparedStatement.executeUpdate();

    }

    public User get(String id) throws ClassNotFoundException, SQLException {
    	

    	Class.forName("com.mysql.jdbc.Driver");
    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/springbook", "spring", "book");  	
    	
        String sql = "select id, name, password from users where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        
        User user = new User();
        user.setId(rs.getString("id"));
        user.setPassword(rs.getString("password"));
        user.setuserName(rs.getString("userName"));

        rs.close();
        preparedStatement.close();
        connection.close();
        
        return user;
        
    }

}
