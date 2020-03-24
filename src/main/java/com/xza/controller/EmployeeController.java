package com.xza.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xza.mapper.DepartmentMapper;
import com.xza.mapper.EmployeeMapper;
import com.xza.pojo.Department;
import com.xza.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author 拾柒
 * @create 2020/3/22
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 员工数据列表页面
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public  String list(Model model){
        List<Employee> employees=employeeMapper.getEmployees();
        model.addAttribute("emps",employees);
        return "employee/list";
    }

    /**
     * 添加界面
     * @param model 部门信息
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 应该要携带部门的数据信息
        List<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("departments", departments);
        return "employee/add";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println(employee);
        employeeMapper.save(employee);
        //添加完毕后应该返回首页，重定向url会变化，请求转发url不会变化
        return "redirect:/emps";
    }

    @GetMapping("/emp/update/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model){
        //回显出用户的信息
        Employee employee = employeeMapper.get(id);
        model.addAttribute("employee",employee);
        // 应该要携带部门的数据信息
        List<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("departments", departments);
        return "employee/update";

    }

    @PostMapping("/emp/update")
    public String updateEmp(Employee employee){
        employeeMapper.update(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/delete/{id}")
    public String delEmp(@PathVariable("id") Integer id){
        employeeMapper.delete(id);
        return "redirect:/emps";
    }

}
