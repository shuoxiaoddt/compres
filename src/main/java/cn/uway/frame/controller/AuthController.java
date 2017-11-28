package cn.uway.frame.controller;

import cn.uway.frame.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by uwayxs on 2017/11/21.
 */
@Controller
public class AuthController {

    @RequestMapping("/login")
    public String login(UserInfo user){



        return "index";
    }
}
