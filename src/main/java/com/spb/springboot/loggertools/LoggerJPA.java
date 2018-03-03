package com.spb.springboot.loggertools;

import org.springframework.data.jpa.repository.JpaRepository;

//请求日志数据接口
public interface LoggerJPA extends JpaRepository<LoggerEntity,Long> {

}
