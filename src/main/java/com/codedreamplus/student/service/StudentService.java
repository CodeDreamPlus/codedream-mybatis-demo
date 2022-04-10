package com.codedreamplus.student.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codedreamplus.student.entity.Student;
import com.codedreamplus.student.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
 * @author ShiJianlong
 * @date 2022/3/18 00:04
 */
@Service
public class StudentService extends ServiceImpl<StudentMapper, Student> {

    public void testUpdate(String name){
        baseMapper.testUpdate(name);
    }
}
