package org.wing.dissertation.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.wing.dissertation.domain.Menitor;
import org.wing.dissertation.service.MenitorService;

import javax.security.auth.login.AccountException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyShrioRealm extends AuthorizingRealm {
    @Autowired
    private MenitorService menitorService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限认证");
        Menitor menitor= (Menitor) SecurityUtils.getSubject().getPrincipal();
        String menitorId= String.valueOf(menitor.getId());
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> roleSet=new HashSet<>();
        roleSet.add(menitorId);
        info.addRoles(roleSet);
        Set<String> permissionSet=new HashSet<>();
        permissionSet.add(menitorId);
        info.setStringPermissions(permissionSet);
        return info;
    }

    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("身份认证");
        UsernamePasswordToken token =(UsernamePasswordToken) authenticationToken;
        System.out.println(token.getUsername()+token.getPassword());
        String name = token.getUsername();
        String password = String.valueOf(token.getPassword());
        Map<String,Object> map=new HashMap<>();
        map.put("loginName",name);
        //将明文转为密文
        String pwd=password;
        String pwdDES=MyDES.encryptBasedDes(pwd);
        map.put("password",pwdDES);
        //System.out.println(pwdDES);
        Menitor menitor=null;
        menitor=menitorService.login(map);
        if (menitor==null){
            try {
                throw new AccountException("帐号或密码不正确");
            } catch (AccountException e) {
                e.printStackTrace();
            }
        }
        SecurityUtils.getSubject().getSession().setTimeout(360000000);
        return new SimpleAuthenticationInfo(menitor,password,getName());
    }
}
