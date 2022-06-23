package com.minhw.controller;

import com.minhw.common.config.IminhwProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw or mz
 * @create: 2022-06-21 13:52
 **/
@RestController
public class Hello {

    @Autowired
    private IminhwProperties proConfig;

    @RequestMapping("/t")
    public String t(){
        System.out.println(proConfig);
        return "";
    }
}
