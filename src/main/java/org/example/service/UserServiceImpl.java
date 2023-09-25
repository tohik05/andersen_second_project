package org.example.service;

import org.example.dao.User;
import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService{
    private final UserDao userDao = UserDaoImpl.getInstance();
    private static UserService userService;
    private static UserMapper userMapper = UserMapper.getInstance();

    public static UserService getInstance(){
        if (userService == null){
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public List<UserDtoFull> getAll() {
        return userDao.getAll().stream()
                .map(userMapper::mapToDtoFull)
                .collect(Collectors.toList());
    }

    @Override
    public UserDtoFull getById(Long id) {
        return userMapper.mapToDtoFull(userDao.getById(id));
    }

    @Override
    public UserDtoFull create(UserDtoCreate userDto) {
        User user = userDao.create(userMapper.mapCreateToEntity(userDto));
        return userMapper.mapToDtoFull(user);
    }

    @Override
    public UserDtoFull update(UserDtoFull userDto) {
        User user = userDao.update(userMapper.mapFullToEntity(userDto));
        return userMapper.mapToDtoFull(user);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}
