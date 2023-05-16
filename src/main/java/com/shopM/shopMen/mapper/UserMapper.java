package com.shopM.shopMen.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.shopM.shopMen.controller.dto.UserDto;
import com.shopM.shopMen.entity.Users;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    //UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mappings(value = {
    		@Mapping(source = "userNo", target = "userNo"),
    	    @Mapping(source = "userName", target = "userName"),
    	    @Mapping(source = "userAccount", target = "userAccount"),
    	    @Mapping(source = "userPassword", target = "userPassword"),
    	    @Mapping(source = "userEmail", target = "userEmail")
    })
    UserDto usersToUserDto(Users users);

    @Mappings(value = {
    		@Mapping(source = "userNo", target = "userNo"),
    	    @Mapping(source = "userName", target = "userName"),
    	    @Mapping(source = "userAccount", target = "userAccount"),
    	    @Mapping(source = "userPassword", target = "userPassword"),
    	    @Mapping(source = "userEmail", target = "userEmail")
    })
    Users userDtoToUsers(UserDto userDto);
}
