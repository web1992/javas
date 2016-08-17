package cn.web1992.controller;

import javax.servlet.http.HttpServletRequest;

import cn.web1992.api.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
public class IndexController {

    @Autowired
    HelloWorldService helloWorldService;

    @RequestMapping("/index.html")
    public String render(ModelMap map, HttpServletRequest request) {
        return "index";
    }


    /**
     * 这里让spring 来控制主页，web.xml 的 welcome-file-list  不起作用
     * @return index.vm
     */
    @RequestMapping(value = {" ", "/"})
    public ModelAndView index() {
        helloWorldService.sayHello();
        Map<String,String> map=new HashMap<>();
        map.put("hi",helloWorldService.sayHi());
        return new ModelAndView("index",map);// index.vm
    }


}