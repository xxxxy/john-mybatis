package com.john.mapper;

import com.john.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDynamicMapper {
    public User getUserByCondition(User user);

    public User getUserByCondition2(User user);

    public User getUserByCondition3(User user);

    public Integer updateUserByCondition(User user);

    public List<User> getUsersByIds(List<Integer> ids);

    public Integer batchSaveUsers(@Param("users") List<User> userList);
}
