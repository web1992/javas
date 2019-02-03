package cn.web1992.service;

/**
 * author: web1992
 * date: 2017/11/15
 * time: 17:27
 * Description:
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public void login() {
        System.out.println("login");
    }
    public  void init(){
        System.out.println("UserServiceImpl:init");
    }
}

