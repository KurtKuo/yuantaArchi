package com.shopM.shopMen.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.shopM.shopMen.controller.dto.UserDto;
import com.shopM.shopMen.service.UsersService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DirtiesContext
@DisplayName("測試 FidoAuthorizationsController")
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc(addFilters = false)
public class UsersConrtollerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@DisplayName("測試 API FIDO授權請求-授權請求")
	void testSearchByAccount() throws Exception {
		// Arrange
	    String account = "john123";
	    UserDto userDto = new UserDto();
	    UsersService usersService = Mockito.mock(UsersService.class);
	    Mockito.when(usersService.getUserByAccount(account)).thenReturn(userDto);

	    // Act
	    MvcResult mvcResult = this.mockMvc.perform(get("/shopM/" + account + "/account")).
	    		andDo(print()).andExpect(status().isOk()).andReturn();
	}
}
