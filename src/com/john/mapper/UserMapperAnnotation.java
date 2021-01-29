package com.john.mapper;

import com.john.bean.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapperAnnotation {

    @Select("select * from test_user where id = #{id}")
    public User getUserById(Integer id);
}
