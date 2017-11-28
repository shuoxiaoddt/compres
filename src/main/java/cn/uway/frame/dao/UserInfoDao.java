package cn.uway.frame.dao;

import cn.uway.frame.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by uwayxs on 2017/11/16.
 */
public interface UserInfoDao extends JpaRepository<UserInfo,Long>{


    UserInfo findByUsername(String name);

}
