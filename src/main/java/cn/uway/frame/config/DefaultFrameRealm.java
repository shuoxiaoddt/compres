package cn.uway.frame.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by uwayxs on 2017/11/16.
 */
public class DefaultFrameRealm extends AuthorizingRealm {

    /**
     * 身份验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        Object principal = token.getPrincipal(); //username
        Object credentials = token.getCredentials();//password

        if ("admin".equals(principal) && "123456".equals(credentials)){
            return new SimpleAuthenticationInfo(principal,credentials,getName());
        }
        return null;
    }

    /**
     * 权限管理
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
