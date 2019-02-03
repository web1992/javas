package cn.web1992.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * author: web1992
 * date: 2017/11/15
 * time: 17:27
 * Description:
 */
public class UserServiceImpl implements UserService {

    private  LoginService loginService;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void sayName() {
        System.out.println("name");
        System.out.println("UserServiceImpl:sayName loginService="+loginService);
    }
    public  void init(){
        System.out.println("UserServiceImpl:init");
        System.out.println("UserServiceImpl:init loginService="+loginService);
    }
}

