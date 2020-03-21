package com.xza.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 拾柒
 * @create 2020/3/19
 */
// 员工类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    // 1 male， 0 female
    private Integer gender;
    private Integer department; // 部门使用id表示；具体的类
    private Date birth;

    // 大厂不允许我们使用联表查询，需要设计冗余字段；
    private Department eDepartment;

}