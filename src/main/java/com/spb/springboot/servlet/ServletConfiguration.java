package com.spb.springboot.servlet;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServletComponentScan
public class ServletConfiguration {
    /**
     * 方法一：
     *  使用Bean注册servlet
     * @return
     */
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        return new ServletRegistrationBean(new TestServlet(),"/test");
//    }

    /**
     * 方法二：
     *  自动装配
     *  SpringBoot内部提供了注解@ServletComponentScan，这个注解的作用就是自动扫描SpringBoot项目内的有关Servlet配置，自动装配到项目中
     *
     *  使用方法二时，需要修改TestServlet，在类上添加 @WebServlet 注解
     */

}
