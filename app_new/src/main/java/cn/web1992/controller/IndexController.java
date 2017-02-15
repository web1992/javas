package cn.web1992.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {
    /**
     * 这里让spring 来控制主页，web.xml 的 welcome-file-list  不起作用
     * @return index.vm
     */
    @RequestMapping(value = {" ", "/"})
    @ResponseBody
    public String index() {
        return "200";
    }


    @RequestMapping(value = {"/index2"},params = {"a=123"})
    @ResponseBody
    public String index2() {
        return "index2";
    }
}
