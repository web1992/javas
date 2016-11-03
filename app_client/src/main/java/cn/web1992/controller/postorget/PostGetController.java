package cn.web1992.controller.postorget;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by web1992 on 2016/10/10.
 *
 * @desc spring post,get
 *
 * RequestBody 获取的参数是在请求Body 里面的参数。如果参数是?name=Lucy,次参数并不会有值 [用于post]
 *
 * RequestParam 是获取?age=123 中的参数，如果参数再body 中，依然获取不到参数 [用于get]
 *
 */
@Controller
public class PostGetController {

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    public String post(@RequestBody String name,@RequestParam int age) {
        return String.format("post name=%s,age=%s", name,age);
    }
}
