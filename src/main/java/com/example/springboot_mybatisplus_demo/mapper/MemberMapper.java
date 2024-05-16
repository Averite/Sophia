package com.example.springboot_mybatisplus_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_mybatisplus_demo.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {


}
