package com.xza.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 拾柒
 * @create 2020/3/19
 */
// 部门类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Integer id;
    private String departmentName;

}
