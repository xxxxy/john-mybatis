package com.john.mapper;

import com.john.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public User getUserByIdAndName(Integer id, String name);

    public User getUserByIdAndName1(@Param("id") Integer id, @Param("name") String name);

    public User getUser(User user);

    public User getUserByIds(List<String> ids);

    public User getUserByMap(Map<String, String> map);

    public User getUserById(Integer id);

    public Integer addUser(User user);

    public boolean updateUser(User user);

    public void deleteUser(Integer id);
}
