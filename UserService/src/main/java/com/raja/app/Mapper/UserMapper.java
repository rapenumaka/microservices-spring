package com.raja.app.Mapper;

import com.raja.app.dto.UserDto;
import com.raja.app.entity.User;

public class UserMapper {


    public static UserDto convertUser(User user){

        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }

    public static User convertUserDto(UserDto userDto){
        return new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
    }
}
