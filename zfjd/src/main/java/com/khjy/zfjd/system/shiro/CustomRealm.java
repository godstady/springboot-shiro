package com.khjy.zfjd.system.shiro;

import com.khjy.zfjd.system.bean.TSUser;
import com.khjy.zfjd.system.service.impl.TSUserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by godstady on 2020/6/16.
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private TSUserServiceImpl service;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取用户输入的账号
        String username = (String)authenticationToken.getPrincipal();
        //2.通过username从数据库中查找到user实体
        TSUser user = new TSUser();
        user.setUserno(username);
        TSUser t = service.getUser(username);
        if(t == null){
            return null;
        }
        //3.通过SimpleAuthenticationInfo做身份处理
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(t,t.getPassword(),getName());
        //4.用户账号状态验证等其他业务操作

        //5.返回身份处理对象
        return simpleAuthenticationInfo;
    }
}
