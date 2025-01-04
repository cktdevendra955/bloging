package com.core.bloging.controller;

import com.core.bloging.payloads.ApiResponse;
import com.core.bloging.payloads.UserDto;
import com.core.bloging.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping
//    ResponseEntity<UserDto> getAll(){
//        return new ResponseEntity<>(this.userService.getAll(),HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto user = this.userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<UserDto> updateById(@RequestBody UserDto userDto,@PathVariable Integer id){
        UserDto updated = this.userService.updateById(userDto, id);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Integer id){
        this.userService.deleteById(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted",true),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.ok(this.userService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok(this.userService.getById(id));
    }
}
