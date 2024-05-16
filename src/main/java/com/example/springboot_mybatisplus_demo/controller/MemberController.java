package com.example.springboot_mybatisplus_demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot_mybatisplus_demo.entity.Member;
import com.example.springboot_mybatisplus_demo.mapper.MemberMapper;
import com.example.springboot_mybatisplus_demo.service.IMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private IMember memberService;

    @Autowired
    private MemberMapper memberMapper;

    /**
     * 查询会员信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("getInfo/{id}")
    public Member getMemberInfo(@PathVariable Integer id){
        return memberService.getById(id);
    }

    /**
     * 插入会员信息
     * @param member
     */
    @ResponseBody
    @RequestMapping("/insert")
    public String insertInfo(Member member){
        member.setMemberId(null);
        boolean b = memberService.save(member);
        if(!b){
            return "false";
        }
        return "true";
    }

    @RequestMapping("/selectByName")
    public String selectByName(Model model,String memberName){
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("memberName", memberName); // 注意这里使用的是数据库字段名
        List<Member> list = memberMapper.selectList(queryWrapper);
        model.addAttribute("members",list);
        return "index";
    }

    /**
     * 查询全部会员信息
     * @return
     */
    @RequestMapping("/selectAll")
    public String selectAll(Model model){
        List<Member> list = memberService.list();
        model.addAttribute("members",list);
        return "index";
    }

    /**
     * 根据id更新会员信息
     * @param member
     */
    @ResponseBody
    @RequestMapping("/update")
    public String updateById(Member member){
        boolean b = memberService.updateById(member);
        if(!b){
            return "false";
        }
        return "true";
    }

    /**
     * 根据id删除会员信息
     * @param id
     */
    @ResponseBody
    @RequestMapping("/delete")
    public String deleteById(String id){
        boolean b = memberService.removeById(id);
        if(!b){
            return "false";
        }
        return "true";
    }


}
