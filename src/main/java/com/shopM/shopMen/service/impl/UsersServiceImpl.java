package com.shopM.shopMen.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopM.shopMen.controller.dto.UserDto;
import com.shopM.shopMen.entity.Users;
import com.shopM.shopMen.mapper.UserMapper;
import com.shopM.shopMen.repository.UsersDao;
import com.shopM.shopMen.service.UsersService;

@Transactional(rollbackFor = Exception.class)
@Service
public class UsersServiceImpl implements UsersService{
	
	// 定義常量錯誤訊息和成功訊息
	private static final String ERROR_MESSAGE = "error";
	private static final String SUCCESS_MESSAGE = "success";
	
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private UserMapper userMapper;
	
	
    /**
     * 會員註冊方法
     * @param userDto 註冊的會員資訊
     * @return UserDto 回傳處理後的會員資訊
     * @throws Exception
     */
	@Override
	public UserDto register(UserDto userDto) throws Exception {
	    if (userDto.getUserAccount() == null) {
	        userDto.setMessage(ERROR_MESSAGE);
	        return userDto;
	    }
	    
	    Users user = userMapper.userDtoToUsers(userDto);
	    
	    user.setUserCreatedAt(new Date());
	    user.setUpdatedAt(new Date());
	    usersDao.save(user);

	    userDto.setMessage(SUCCESS_MESSAGE);
	    return userDto;
	}

    /**
     * 會員註冊方法
     * @param userDto 註冊的會員資訊
     * @return UserDto 回傳處理後的會員資訊
     * @throws Exception
     */
    @Override
    public UserDto getUserByUserNo(Long userNo) throws Exception {
		
		return getUserByUserNo("search", userNo);
    }
    
    /**
     * 根據會員編號查詢會員方法
     * @param userNo 查詢會員的編號
     * @return UserDto 回傳處理後的會員資訊
     * @throws Exception
     */
	@Override
	public UserDto deleteUserByUserNo(Long userNo) throws Exception {
		
		return getUserByUserNo("delete", userNo);
	}

	/**
     * 根據會員帳號查詢會員方法
     * @param userAccount 查詢會員的帳號
     * @return UserDto 回傳處理後的會員資訊
     * @throws Exception
     */
	@Override
	public UserDto getUserByAccount(String userAccount) throws Exception {
		return getUserByType("userAccount", userAccount);
	}
	
	/**
     * 根據email查詢會員方法
     * @param userEmail 查詢會員的帳號
     * @return UserDto 回傳處理後的會員資訊
     * @throws Exception
     */
	@Override
	public UserDto getUserByEmail(String userEmail) throws Exception {
		return getUserByType("userEmail", userEmail);
	}

    /**
     * 會員登入
     * @param userAccount 註冊的會員帳號
     * @param password 註冊的會員密碼
     * @return UserDto 回傳處理後的會員資訊
     * @throws Exception
     */
	@Override
	public UserDto login(String userAccount, String password) throws Exception {
		return null;
	}
	
    /**
     * 會員登出
     * @param userNo 註冊的會員編號
     * @return UserDto 回傳處理後的會員資訊
     * @throws Exception
     */
	@Override
	public UserDto logout(Long userNo) throws Exception {
		return null;
	}
	
	/**
     * 根據不同方式查詢
     * @param type 查詢類別
     * @param info 帳號 or Email
     * @return UserDto 回傳處理後的會員資訊
     * @throws Exception
     */
	private UserDto getUserByType(String type, String info) throws Exception {
	    if (info == null || type == null) {
	        UserDto userDto = new UserDto();
	        userDto.setMessage(ERROR_MESSAGE);
	        return userDto;
	    }

	    Users user = null;
	    switch (type) {
	        case "userAccount":
	            user = usersDao.findByUserAccount(info);
	            break;
	        case "userEmail":
	            user = usersDao.findByUserEmail(info);
	            break;
	    }

	    UserDto userDto = userMapper.usersToUserDto(user);

	    return handleUserDto(userDto, user);
	}
	
	/**
     * 根據會員編號執行
     * @param type 查詢類別
     * @param userNo 會員編號
     * @return UserDto 回傳處理後的會員資訊
     * @throws Exception
     */
	private UserDto getUserByUserNo(String type, Long userNo) throws Exception {
	    if (userNo == null || type == null) {
	        UserDto userDto = new UserDto();
	        userDto.setMessage(ERROR_MESSAGE);
	        return userDto;
	    }

	    Optional<Users> user = null;
	    switch (type) {
	        case "search":
	            user = usersDao.findById(userNo);
	            break;
	        case "delete":
	            usersDao.deleteById(userNo);
	            user = usersDao.findById(userNo);
	            break;
	        default:
	        	throw new IllegalArgumentException("Invalid operation type: " + type);
	    }
	    
	    UserDto userDto = userMapper.usersToUserDto(user.orElse(null));
	    
	    if (type.equals("search")) {
	    	if (userDto == null) {
		        userDto = new UserDto();
		        userDto.setMessage(ERROR_MESSAGE);
		    }
	    } else if (type.equals("delete")) {
	    	if (user.isPresent()) {
	    		userDto = new UserDto();
		        userDto.setMessage(ERROR_MESSAGE);
	    	} else {
	    		userDto.setMessage(SUCCESS_MESSAGE);
	    	}
	    }
	    
	    return userDto;
	}
	
	/**
	 * 相似錯誤處理
	 * @param userDto
	 * @param user
	 * @return
	 */
	private UserDto handleUserDto(UserDto userDto, Users user) {
	    if (userDto == null) {
	        userDto = new UserDto();
	        userDto.setMessage(ERROR_MESSAGE);
	    } else {
	        userDto.setMessage(SUCCESS_MESSAGE);
	    }
	    
	    return userDto;
	}
}
