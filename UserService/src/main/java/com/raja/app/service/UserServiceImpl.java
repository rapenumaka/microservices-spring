package com.raja.app.service;

import com.raja.app.Mapper.UserMapper;
import com.raja.app.dto.UserDto;
import com.raja.app.entity.User;
import com.raja.app.exception.UserNotFoundException;
import com.raja.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(user -> {
             return  UserMapper.convertUser(user);
        }).collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
      return  UserMapper.convertUser( userRepository.save(UserMapper.convertUserDto(userDto)));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        if(userRepository.existsById(userDto.getId())){
            User existingUser = userRepository.findById(userDto.getId()).get();
            existingUser.setEmail(userDto.getEmail());
            existingUser.setFirstName(userDto.getFirstName());
            existingUser.setLastName(userDto.getLastName());
            userRepository.save(existingUser);

        }else{
            throw new UserNotFoundException("User not found");
        }
        return null;
    }

    @Override
    public void deteleUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteAllById(Collections.singleton(userId));
        } else {
            throw new UserNotFoundException("User not found");
        }

    }


    @Override
    public UserDto getUser(Long id) {

       User user = userRepository.findById(id).orElseThrow(
                () -> {
                    throw new UserNotFoundException("User Not Found exception");
                }
        );
      return UserMapper.convertUser(user);
    }
}
