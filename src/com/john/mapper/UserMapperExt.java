package com.john.mapper;

import com.john.bean.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapperExt {

    public User getById(Integer id);
}
