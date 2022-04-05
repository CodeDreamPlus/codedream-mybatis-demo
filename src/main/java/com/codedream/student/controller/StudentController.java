package com.codedream.student.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codedream.student.entity.Student;
import com.codedream.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ShiJianlong
 * @date 2022/3/18 00:07
 */
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 测试原始分页对象构建
     *
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/page")
    public IPage<Student> listPage(@RequestParam Integer current, @RequestParam Integer size) {
        Page<Student> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        return studentService.page(page);
    }

    @PostMapping
    public boolean create(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        Student oldStudent = studentService.getOne(new QueryWrapper<Student>().lambda().eq(Student::getName, student.getName()));
        oldStudent.setGrade(student.getGrade());
        studentService.updateById(oldStudent);
    }

    @PutMapping("/noEntity")
    public void updateNoEntity(@RequestBody Student student) {
        studentService.update(new UpdateWrapper<Student>().lambda()
                .eq(Student::getName, student.getName())
                .set(Student::getGrade, student.getGrade())
                .set(Student::getSex, student.getSex())
        );
    }

    @PutMapping("/diyUpdate")
    public void executeDiyUpdate(@RequestParam String name) {
        studentService.testUpdate(name);
    }

    /**
     * 测试全部删除
     * @return
     */
    @DeleteMapping
    public String delete() {
        try {
            studentService.remove(new QueryWrapper<>());
        } catch (Exception e) {
            return e.getMessage();
        }
        return "成功";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        try {
            studentService.removeById(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "成功";
    }

    @GetMapping
    public Page<Student> list(Page<Student> page) {
        return studentService.page(page);
    }

}
