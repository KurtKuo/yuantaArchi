package com.shopM.shopMen.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDto {
	
    @Schema(description = "使用者編號")
    private Long userNo;

    @Schema(description = "使用者名稱")
    private String userName;

    @Schema(description = "使用者帳號")
    private String userAccount;

    @Schema(description = "使用者密碼")
    private String userPassword;

    @Schema(description = "使用者信箱")
    private String userEmail;

    @Schema(description = "訊息")
    private String message;
}