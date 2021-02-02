package com.john.mapper;

import com.john.bean.Department;

public interface DepartmentMapper {

    public Department getDepartment(Integer id);

    public Department getDepartmentPlus(Integer id);

    public Department getDepartmentStep(Integer id);
}
