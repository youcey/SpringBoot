package com.spb.springboot.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    //logback
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);
    /**
     * 访问首页
     * @return
     */
    @RequestMapping(value = "/test1")
    public String index()
    {
        logger.debug("Test -> 记录debug日志");
        logger.info("Test -> 访问了index方法");
        logger.error("Test -> 记录error错误日志");
        return "test1";
    }
}
