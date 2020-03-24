package com.xza.mapper;

import com.xza.pojo.Department;
import com.xza.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 拾柒
 * @create 2020/3/19
 */
@Mapper
@Repository
public interface EmployeeMapper {
   //获取全部的员工信息
    List<Employee> getEmployees();

    //新增一个员工信息
    int save(Employee employee);

    //通过id获取员工
    Employee get(Integer id);

    //通过id删除员工
    int delete(Integer id);

    //修改员工
    void update(Employee employee);
}
