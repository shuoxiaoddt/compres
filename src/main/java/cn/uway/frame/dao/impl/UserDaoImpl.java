package cn.uway.frame.dao.impl;

import cn.uway.frame.dao.UserDao;
import cn.uway.frame.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by uwayxs on 2017/11/16.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User findByName(String name) {
        return new User();
    }
}
