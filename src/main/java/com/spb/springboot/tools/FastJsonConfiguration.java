package com.spb.springboot.tools;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FastJsonConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //调用父类的配置
        super.configureMessageConverters(converters);

        // 1.先定义一个convert转换器对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        // 2. 配置添加fastjson的配置信息, 比如: 是否要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        /**
         * setSerializerFeatures方法可以配置多个过滤方式:
         *  WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
         *  WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
         *  DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
         *  WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
         *  WriteMapNullValue：是否输出值为null的字段,默认为false。
         */
        fastJsonConfig.setSerializerFeatures(/*SerializerFeature.PrettyFormat,*/
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty);

        // 3.把配置信息添加到convert转换器对象中
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //4. 解决中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        //修改配置返回内容的过滤
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        // 5.将convert添加到转换器对象当中
        converters.add(fastConverter);
    };
}
