package cn.uway.frame.config;

import cn.uway.frame.grammerlearn.ClassProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by uwayxs on 2017/11/16.
 */
@Configuration
public class GrammerConfiguration {

    @Bean("classProxyFactoryBean")
    public ClassProxyFactoryBean classProxyFactoryBean() throws Exception {
        return new ClassProxyFactoryBean(
                "cn.uway.frame.dao.UserDao",
                Class.forName("cn.uway.frame.dao.impl.UserDaoImpl").newInstance());
    }

}
