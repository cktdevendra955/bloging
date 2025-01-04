package com.core.bloging.service.impl;

import com.core.bloging.entity.UserEntity;
import com.core.bloging.exceptions.ResourceNotFundException;
import com.core.bloging.payloads.UserDto;
import com.core.bloging.repository.UserRepo;
import com.core.bloging.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity user = this.dtoToUser(userDto);
        user.setCreatedAt(new Date());
        UserEntity saved = this.userRepo.save(user);
        return this.useToDto(saved);
    }

    @Override
    public UserDto updateById(UserDto userDto, Integer id) {
        UserEntity user = this.userRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFundException("User ","ID ",id));

        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUpdatedAt(new Date());
        UserEntity update = this.userRepo.save(user);
        UserDto savedUserDto = this.useToDto(update);
        return savedUserDto;
    }

    @Override
    public UserDto getById(Integer id) {
        UserEntity user = this.userRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFundException("User ","ID ",id));
        return this.useToDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<UserEntity> users = this.userRepo.findAll();
        List<UserDto> collect = users.stream().map(user -> this.useToDto(user)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteById(Integer id) {
        UserEntity user = this.userRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFundException("User ","ID ",id));
        this.userRepo.delete(user);
    }

    public UserEntity dtoToUser(UserDto userDto){

        UserEntity user = new UserEntity();

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());

        user.setCreatedAt(userDto.getCreatedAt());
        user.setUpdatedAt(userDto.getUpdateddAt());
        return user;
    }

    public UserDto useToDto(UserEntity userEntity){
       UserDto userDto = new UserDto();

       userDto.setId(userEntity.getId());
       userDto.setName(userEntity.getName());
       userDto.setEmail(userEntity.getEmail());
       userDto.setAbout(userEntity.getAbout());
       userDto.setPassword(userEntity.getPassword());

       userDto.setCreatedAt(userEntity.getCreatedAt());
       userDto.setUpdateddAt(userEntity.getUpdatedAt());
       return userDto;
    }




}
