package cn.web1992.controller.pathvariable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by web1992 on 2016/10/10.
 *
 * @desc spring mvc 获取path 变量
 */
@Controller
public class PathVariableController {

    @RequestMapping(value = "/path/{name}")
    @ResponseBody
    public String pathVariable(@PathVariable String name) {
        return String.format("name=%s", name);
    }
}
