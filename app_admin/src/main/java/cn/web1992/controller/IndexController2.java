package cn.web1992.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by web1992 on 2016/8/22.
 *
 * @desc
 */IndexController
@Controller
public class IndexController2 {


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
        return new ModelAndView("index");// index.vm
    }


}
