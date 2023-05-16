package com.shopM.shopMen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopM.shopMen.service.UsersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import com.shopM.shopMen.controller.dto.UserDto;

@Slf4j
@RestController
@RequestMapping("/shopM")
@Tag(name = "Users", description = "用户操作接口")
public class UsersController {
	
	@Autowired
    private UsersService usersService;
	
	@PostMapping("/")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Success",
	                content = {
	                        @Content(
	                                mediaType = "application/json",
	                                array = @ArraySchema(schema = @Schema(implementation = UserDto.class))
	                        )
	                }),
	        @ApiResponse(responseCode = "401", description = "參數錯誤", content = {
	                @Content()
	        })
	})
	@Operation(summary = "用戶註冊", description = "用戶註冊接口")
	public UserDto registerUser(@RequestBody UserDto userDto) throws Exception {
	    return usersService.register(userDto);
	}
	
	@GetMapping("/{userNo}/search")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Success",
	                content = {
	                        @Content(
	                                mediaType = "application/json",
	                                array = @ArraySchema(schema = @Schema(implementation = UserDto.class))
	                        )
	                }),
	        @ApiResponse(responseCode = "401", description = "參數錯誤", content = {
	                @Content()
	        })
	})
	@Operation(summary = "根據會員員編查詢用戶", description = "根據會員員編查詢用戶接口")
	public UserDto getUserById(@PathVariable @NotNull(message = "userNo不可為Null") Long userNo) throws Exception {
	    return usersService.getUserByUserNo(userNo);
	}
	
	@DeleteMapping("/{userNo}/delete")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Success",
	                content = {
	                        @Content(
	                                mediaType = "application/json",
	                                array = @ArraySchema(schema = @Schema(implementation = UserDto.class))
	                        )
	                }),
	        @ApiResponse(responseCode = "401", description = "參數錯誤", content = {
	                @Content()
	        })
	})
	@Operation(summary = "根據會員員編刪除用戶", description = "根據會員員編刪除用戶接口")
	public UserDto deleteUser(@PathVariable @NotNull(message = "userNo不可為Null") Long userNo) throws Exception {
	    return usersService.deleteUserByUserNo(userNo);
	}
	
	@GetMapping("/{info}/account")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Success",
	                content = {
	                        @Content(
	                                mediaType = "application/json",
	                                array = @ArraySchema(schema = @Schema(implementation = UserDto.class))
	                        )
	                }),
	        @ApiResponse(responseCode = "401", description = "參數錯誤", content = {
	                @Content()
	        })
	})
	@Operation(summary = "根據會員帳號查詢用戶", description = "根據會員帳號查詢用戶接口")
	public UserDto getUserByAccount(@PathVariable @NotNull(message = "info不可為Null") String info) throws Exception {
		return usersService.getUserByAccount(info);
	}
	
	@GetMapping("/{info}/email")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Success",
	                content = {
	                        @Content(
	                                mediaType = "application/json",
	                                array = @ArraySchema(schema = @Schema(implementation = UserDto.class))
	                        )
	                }),
	        @ApiResponse(responseCode = "401", description = "參數錯誤", content = {
	                @Content()
	        })
	})
	@Operation(summary = "根據會員email查詢用戶", description = "根據會員帳號查詢用戶接口")
	public UserDto getUserByEmail(@PathVariable @NotNull(message = "info不可為Null") String info) throws Exception {
	    return usersService.getUserByEmail(info);
	}
}