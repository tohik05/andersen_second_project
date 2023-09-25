package org.example.service;

import java.util.List;

public interface UserService {

    List<UserDtoFull> getAll();

    UserDtoFull getById(Long id);

    UserDtoFull create(UserDtoCreate user);

    UserDtoFull update(UserDtoFull user);

    void deleteById(Long id);
}
