package com.example.springbootshiro.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier(value = "securityManager") DefaultSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/user/add", "perms[user:add]");
        map.put("/user/*", "authc");

        bean.setFilterChainDefinitionMap(map);
        bean.setLoginUrl("/tologin");
        return bean;
    }

    @Bean("securityManager")
    public DefaultSecurityManager getDefaultSecurityManager(@Qualifier(value = "userRealm") UserRealm userRealm) {
//        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 创建realm对象
    @Bean("userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }

}
