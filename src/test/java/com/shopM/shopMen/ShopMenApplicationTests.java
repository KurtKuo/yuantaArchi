package com.shopM.shopMen;

import java.sql.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.shopM.shopMen.controller.dto.UserDto;
import com.shopM.shopMen.entity.Users;
import com.shopM.shopMen.mapper.UserMapper;
import com.shopM.shopMen.service.UsersService;

@SpringBootTest
@ActiveProfiles("test")
class ShopMenApplicationTests {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UsersService usersService;
	
	@Test
    void testConnection() {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("Connected to database: " + conn.getMetaData().getDatabaseProductName());
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT 1");
            rs.next();
            System.out.println(rs.getInt(1));
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
        }
    }

	
	@Test
    void testMapper	() {
        Users users = new Users();
        users.setUserName("nameTest");
        users.setUserAccount("peter151");
        users.setUserPassword("password");
        UserDto userDto = userMapper.usersToUserDto(users);
        System.out.println(userDto.getUserPassword());
        
        Users users2 = new Users();
        UserDto userDto2 = new UserDto();
        users2.setUserAccount("mike789");
        try {
        	userDto2 = usersService.getUserByAccount("mike789");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(userDto2.getUserPassword());
    } 
	
	@Test
	void contextLoads() {
	}

}
