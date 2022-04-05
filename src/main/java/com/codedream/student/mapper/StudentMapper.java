package com.codedream.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codedream.student.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ShiJianlong
 * @date 2022/3/18 00:02
 */
public interface StudentMapper extends BaseMapper<Student> {
    void testUpdate(@Param("name") String name);
}
