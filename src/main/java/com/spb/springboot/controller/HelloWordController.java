package com.spb.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloWordController {
    /**
     * 测试输出Helloword
     * @return
     */
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String index(){
        return "HelloWord";
    }
}
