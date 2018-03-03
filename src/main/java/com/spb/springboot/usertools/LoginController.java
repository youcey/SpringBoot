package com.spb.springboot.usertools;

import com.spb.springboot.usertools.UserEntity;
import com.spb.springboot.usertools.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/test")
    public String test(String name,String pwd){
        return "登陆成功";
    }

    @RequestMapping(value = "/login")
    public String login(UserEntity user, HttpServletRequest request){
        boolean flag = true;
        String result = "登陆成功";
        UserEntity userEntity = userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"),user.getName()));
                return null;
            }
        });
        //用户不存在
        if(userEntity == null){
            flag = false;
            result = "用户不存在，登陆失败";
        }else if(!userEntity.getPwd().equals(user.getPwd())){
            flag = false;
            result = "用户密码错误，登陆失败";
        }
        //登陆成功，将用户写入session中
        if(flag){
            request.getSession().setAttribute("_session_user",userEntity);
        }
        return result;
    }

}
