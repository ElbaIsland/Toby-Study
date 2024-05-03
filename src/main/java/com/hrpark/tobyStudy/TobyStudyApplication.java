package com.hrpark.tobyStudy;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springbook.user.dao.NConnectionMaker;
import springbook.user.dao.SimpleConnectionMaker;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

@SpringBootApplication
public class TobyStudyApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		SpringApplication.run(TobyStudyApplication.class, args);

		SimpleConnectionMaker selectedConnectionMaker = new NConnectionMaker();
		UserDao dao = new UserDao(selectedConnectionMaker);
		
		User user = new User();
		user.setId("hrpark");
		user.setPassword("1q2w3e");
		user.setuserName("박하람");
		
		dao.add(user);
		
		System.out.println(user.getId()  +" 등록");
		
		User realUser = dao.get(user.getId());
		System.out.println(realUser.getPassword());
		System.out.println(realUser.getuserName());
		
		System.out.println(realUser.getId()  +" 조회");
		
		String delUser = realUser.getId();
		
		dao.delete(realUser);
		
		System.out.println(delUser + " 삭제");
		
	}

}
