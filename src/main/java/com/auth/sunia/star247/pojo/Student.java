package com.auth.sunia.star247.pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: Person
 * @Description:
 * @date 2019/4/24 19:53
 * @描述
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public  class Student {




    private   String name;
    public  Integer age;
    private String sex;


}
