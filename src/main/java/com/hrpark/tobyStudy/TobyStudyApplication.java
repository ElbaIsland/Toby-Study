package com.hrpark.tobyStudy;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.dao.DaoFactory;
import springbook.user.dao.NConnectionMaker;
import springbook.user.dao.SimpleConnectionMaker;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

@SpringBootApplication
public class TobyStudyApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		SpringApplication.run(TobyStudyApplication.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
		UserDao dao = context.getBean("userDao", UserDao.class);
		
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
