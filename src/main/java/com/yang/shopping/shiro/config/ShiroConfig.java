package com.yang.shopping.shiro.config;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.yang.shopping.shiro.realm.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



public class ShiroConfig {


    @Autowired
    private UserRealm userRealm;

    /**
     * 配置 资源访问策略 . web应用程序 shiro核心过滤器配置
     */
    @Bean
    public ShiroFilterFactoryBean factoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        factoryBean.setLoginUrl("/admin/login");
        // 登录成功后要跳转的链接
        factoryBean.setSuccessUrl("/admin/index");
        //未授权界面;
        factoryBean.setUnauthorizedUrl("/admin/error");
        // 自定义filter配置（ 配置 拦截过滤器链）
        factoryBean.setFilterChainDefinitionMap(setFilterChainDefinitionMap());
        return factoryBean;
    }

    /***
     * 配置 SessionManager 防止登录请求带参数
     * @return
     */
    @Bean
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionIdCookieEnabled(false);
        return sessionManager;
    }

    /**
     * 配置 SecurityManager,可配置一个或多个realm
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(sessionManager());
        securityManager.setRealm(userRealm);
        // securityManager.setRealm(xxxxRealm);
        return securityManager;
    }

    /**
     * 开启shiro 注解支持. 使以下注解能够生效 : 需要认证
     * {@link org.apache.shiro.authz.annotation.RequiresAuthentication
     * RequiresAuthentication} 需要用户
     * {@link org.apache.shiro.authz.annotation.RequiresUser RequiresUser} 需要访客
     * {@link org.apache.shiro.authz.annotation.RequiresGuest RequiresGuest}
     * 需要角色 {@link org.apache.shiro.authz.annotation.RequiresRoles
     * RequiresRoles} 需要权限
     * {@link org.apache.shiro.authz.annotation.RequiresPermissions
     * RequiresPermissions}
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    /**
     * 配置 拦截过滤器链. map的键 : 资源地址 ; map的值 : 所有默认Shiro过滤器实例名 默认Shiro过滤器实例 参考 :
     * {@link org.apache.shiro.web.filter.mgt.DefaultFilter}
     */
    private Map<String, String> setFilterChainDefinitionMap() {
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/admin/login","anon");
        filterMap.put("/admin/error","anon");
        filterMap.put("/admin/login/check","anon");
        filterMap.put("/static/**", "anon"); // 公开访问的资源
        filterMap.put("/admin/login/exit", "logout"); // 配置登出页,shiro已经帮我们实现了跳转
        filterMap.put("/**", "authc"); // 所有资源都需要经过验证
        return filterMap;
    }

}