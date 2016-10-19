package cn.web1992.controller.cookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by web1992 on 2016/10/11.
 *
 * @desc cookie 测试
 */
@Controller
public class CookieController {


    @RequestMapping(value = "/cookie")
    @ResponseBody
    public String cookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("testCookie", "I am cookie.");
        cookie.setPath("/");
        //cookie.setDomain("web1992.cn");
        //cookie.setValue("123");
        response.addCookie(cookie);
        return "create cookie suc.";
    }


    @RequestMapping(value = "/getCookie")
    @ResponseBody
    public String getCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String result = "";
        if (null == cookies || cookies.length == 0) {
            return "not cookies";
        }
        for (Cookie cookie : cookies) {
            result += "name=" + cookie.getName() + " value=" + cookie.getValue();
        }
        return result;
    }
}
