package com.spb.springboot.mailtools;

/**
 * 自定义的枚举类型，枚举类型包含了邮件内容的类型，
 * 目前仅仅添加了两种:
 *  一种是html形式
 *  一种则是text形式
 */
public enum MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"), //html格式
    TEXT("text")
            ;
    private String value;

    MailContentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
