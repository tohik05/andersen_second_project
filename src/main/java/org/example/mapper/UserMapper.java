package org.example.mapper;

import org.example.dao.User;
import org.example.service.UserDtoCreate;
import org.example.service.UserDtoFull;

public class UserMapper implements BaseMapper<User, UserDtoCreate, UserDtoFull> {

    private static UserMapper userMapper;
    public static UserMapper getInstance(){
        if (userMapper == null){
            userMapper = new UserMapper();
        }
        return userMapper;
    }

    @Override
    public User mapCreateToEntity(UserDtoCreate userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setAge(userDto.getAge());
        return user;
    }

    @Override
    public User mapFullToEntity(UserDtoFull userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setAge(userDto.getAge());
        return user;
    }

    @Override
    public UserDtoFull mapToDtoFull(User user) {
        UserDtoFull userDto = new UserDtoFull();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setLastname(user.getLastname());
        userDto.setAge(user.getAge());
        return userDto;
    }
}
