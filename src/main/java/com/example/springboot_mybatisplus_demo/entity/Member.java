package com.example.springboot_mybatisplus_demo.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("member")
public class Member {

    @TableId(value = "memberId",type = IdType.AUTO)
    private Integer memberId;

    @TableField("memberNo")
    private String memberNo;

    @TableField("memberName")
    private String memberName;

    @TableField("gender")
    private String gender;

    @TableField("age")
    private int age;

    @TableField("phone")
    private String phone;

    @TableField("personality")
    private String personality;

    @TableField("dueDate")
    private String dueDate;

}
