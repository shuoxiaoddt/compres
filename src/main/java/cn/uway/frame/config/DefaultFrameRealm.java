package cn.uway.frame.config;

import cn.uway.frame.dao.UserInfoDao;
import cn.uway.frame.entity.UserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by uwayxs on 2017/11/16.
 */
public class DefaultFrameRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 身份验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        String username = (String)token.getPrincipal(); //username
        UserInfo userInfo = userInfoDao.findByUsername(username);

        if(userInfo.getState() != 0){
            throw new LockedAccountException("user [" + userInfo.getName() + "] is locked.");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(userInfo,userInfo.getPasspwd(),
                        ByteSource.Util.bytes(userInfo.getCredentialsSalt()),getName());

        return simpleAuthenticationInfo;
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

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-512");
        hashedCredentialsMatcher.setHashIterations(1024);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(false);
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }



}
