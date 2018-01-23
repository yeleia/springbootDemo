package org.wing.dissertation.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wing.dissertation.utils.MyShrioRealm;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //必须设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //如果不设值默认会自动查找web工程目录下的“/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/index");
        //登录成功后跳转的链接
       /* shiroFilterFactoryBean.setSuccessUrl("/test");*/
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/test");
        //拦截器
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<>();
        //配置不会被拦截的链接，顺序判断
        filterChainDefinitionMap.put("/static/**","anon");
        filterChainDefinitionMap.put("/menitor/ajaxLogin","anon");
        filterChainDefinitionMap.put("/toStudentLogin","anon");
        filterChainDefinitionMap.put("/student/**","anon");
        filterChainDefinitionMap.put("/student/ajaxLogin","anon");
        //配置退出过滤器
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/add","perms[权限添加]");
        //过滤链从上往下执行
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("shrio拦截器工厂注入成功");
        return shiroFilterFactoryBean;
    }
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //设置realm
        securityManager.setRealm((Realm) myShrioRealm());
        //securityManager.setRealm((Realm) studentShrioRealm());
        return securityManager;
    }


    /**
     * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     *
     * @return
     */
    @Bean
    public MyShrioRealm myShrioRealm(){
        MyShrioRealm myShrioRealm=new MyShrioRealm();
        return myShrioRealm;
    }

}
