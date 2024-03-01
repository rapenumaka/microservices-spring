package com.raja.app.controller;

import com.raja.app.dto.UserDto;
import com.raja.app.exception.ErrorDetails;
import com.raja.app.exception.UserNotFoundException;
import com.raja.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    //http://localhost:8581/swagger-ui/index.html

    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")
    public ResponseEntity<UserDto> getUserbyId(@PathVariable("id") Long id){
        UserDto userDto =  userService.getUser(id);
        return new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> fetchUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

    @PutMapping("update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        return new  ResponseEntity<>(userService.updateUser(userDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("id") Long id){
        userService.deteleUser(id);
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //localhost:8581/api/v1/create
    @PostMapping("create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto user = userService.createUser(userDto);
        return new ResponseEntity<>(user,HttpStatus.CREATED);

    }

    //UserNotFoundException.class is annotated with @ResponseStatus(value=HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> resourceNotFoundException(UserNotFoundException userNotFoundException, WebRequest webRequest){
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),userNotFoundException.getMessage(),"USER_NOT_FOUND");
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
