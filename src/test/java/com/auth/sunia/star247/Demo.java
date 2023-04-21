package com.auth.sunia.star247;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.ListUtil;
import com.auth.sunia.star247.pojo.Student;
import com.auth.sunia.star247.pojo.Teacher;
import org.springframework.beans.BeanUtils;

public class Demo {


    public static void main(String[] args) {
        Student student = new Student("学生1", 22, "男");
        Teacher teacher = new Teacher("老师 1", "女", ListUtil.of(student));

        Teacher teacher1 = new Teacher();
        BeanUtil.copyProperties(teacher,teacher1);

        System.out.println(teacher);
        System.out.println(teacher1);
        teacher1.getStudents().get(0).setName("1111");
        System.out.println("==========================");

        System.out.println(teacher);
        System.out.println(teacher1);
        System.out.println("==========================");

    }


}
