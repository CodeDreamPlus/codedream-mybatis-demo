package com.codedream.student.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.codedream.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * @author ShiJianlong
 * @date 2022/3/14 10:24
 */
@TableName("student")
@Data
public class Student extends BaseEntity {
    private String name;
    private int sex;
    private int grade;
}
