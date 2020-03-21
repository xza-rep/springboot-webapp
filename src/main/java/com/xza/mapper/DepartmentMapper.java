package com.xza.mapper;

import com.xza.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 拾柒
 * @create 2020/3/19
 */
@Mapper
@Repository
public interface DepartmentMapper {
    //获取所有部门信息
    List<Department> getDepartments();

    //通过id获取部门信息
    Department getDepartment(Integer id);
}
