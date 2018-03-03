package com.spb.springboot.logback;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogBackController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(LogBackController.class);

    @RequestMapping(value = "/logback")
    public String logBack(){
        logger.debug("记录debug日志");
        logger.info("访问了logback方法");
        logger.error("记录error错误方法");
        return "logback";
    }
}
