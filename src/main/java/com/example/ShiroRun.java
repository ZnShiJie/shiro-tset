package com.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.env.BasicIniEnvironment;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.Arrays;

public class ShiroRun {
    public static void main(String[] args) {
        BasicIniEnvironment environment = new BasicIniEnvironment("classpath:shiro.ini");
        SecurityManager securityManager = environment.getSecurityManager();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken("zhangsan", "z3");

        try {
            subject.login(token);
            boolean role = subject.hasRole("role1");
            subject.hasRoles(Arrays.asList("role1", "role2"));
            System.out.println(role);
            System.out.println(subject.isPermitted("user:create"));
            System.out.println(token.toString());
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户错误");
        }
    }
}
