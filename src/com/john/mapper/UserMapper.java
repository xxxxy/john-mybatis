package com.john.mapper;

import com.john.bean.User;

public interface UserMapper {

    public User getUserById(Integer id);

    public boolean addUser(User user);

    public void updateUser(User user);

    public void deleteUser(Integer id);
}
