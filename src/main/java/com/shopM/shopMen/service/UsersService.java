package com.shopM.shopMen.service;

import com.shopM.shopMen.controller.dto.UserDto;

public interface UsersService {

	/**
	 * 會員註冊
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
    UserDto register(UserDto userDto) throws Exception;

    /**
     * 利用會員編號查詢
     * @param userNo
     * @return
     * @throws Exception
     */
    UserDto getUserByUserNo(Long userNo) throws Exception;
    
    /**
     * 利用會員編號刪除
     * @param userNo
     * @return UserDto
     * @throws Exception
     */
    UserDto deleteUserByUserNo(Long userNo) throws Exception;

    /**
     * 利用會員帳號查詢
     * @param userAccount
     * @return
     * @throws Exception
     */
    UserDto getUserByAccount(String userAccount) throws Exception;
    
    /**
     * 利用email查詢
     * @param userEmail
     * @return UserDto
     * @throws Exception
     */
    UserDto getUserByEmail(String userEmail) throws Exception;

    /**
     * 利用會員帳號密碼登入
     * @param userAccount
     * @param password
     * @return UserDto
     * @throws Exception
     */
    UserDto login(String userAccount, String password) throws Exception;
    
    /**
     * 利用會員編號登出
     * @param userNo
     * @return
     * @throws Exception
     */
    UserDto logout(Long userNo) throws Exception;
}