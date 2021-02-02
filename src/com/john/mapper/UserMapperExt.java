package com.john.mapper;

import com.john.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface UserMapperExt {

    public User getById(Integer id);

    public User getUserWithDept(Integer id);

    public User getByIdStep(Integer id);

    public List<User> getUsersByDeptId(Integer deptId);
}
