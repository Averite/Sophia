package com.example.springboot_mybatisplus_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot_mybatisplus_demo.entity.Member;
import com.example.springboot_mybatisplus_demo.mapper.MemberMapper;
import com.example.springboot_mybatisplus_demo.service.IMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMember {

}
