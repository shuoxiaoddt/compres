package cn.uway.frame.dao;

import cn.uway.frame.entity.User;

/**
 * Created by uwayxs on 2017/11/16.
 */
public interface UserDao {


    User findByName(String name);
}
