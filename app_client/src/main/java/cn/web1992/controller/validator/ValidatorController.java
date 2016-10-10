package cn.web1992.controller.validator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by web1992 on 2016/9/29.
 *
 * @desc 测试spring 校验
 */
@Controller
public class ValidatorController {


    @RequestMapping(value = "/validator",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    private String validator(@Valid MyForm myForm,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return String.format("form error=%s",bindingResult.hasErrors());
        }
        return String.format("hello name=%s,age=%s",myForm.getName(),myForm.getAge());
    }
}
