package cn.uway.frame.controller;

import cn.uway.frame.dao.UserDao;
import cn.uway.frame.util.SpringContextUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by uwayxs on 2017/11/16.
 */
@RestController
@RequestMapping("/grammer")
public class GrammerController {

    @RequestMapping("/factoryBean")
    public String FactoryBean(){
        UserDao dao = SpringContextUtil.getApplicationContext().getBean("classProxyFactoryBean", UserDao.class);
        dao.findByName("nn");
        return dao.toString();
    }


}
