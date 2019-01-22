package com.funtl.myshop.service.reg.controller;

import com.funtl.myshop.commons.domain.TbUser;
import com.funtl.myshop.commons.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "reg")
public class RegController {

    @Autowired
    private TbUserMapper tbUserMapper;

    @GetMapping(value = {"{id}"})
    public String reg(@PathVariable long id) {
        TbUser tbUser = tbUserMapper.selectByPrimaryKey(id);
        return tbUser.getUsername();
    }
}
