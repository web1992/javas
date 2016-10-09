package cn.web1992.controller.validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by web1992 on 2016/9/29.
 *
 * @desc  @NotNull @Max 此类注解在控制层返回json 格式数据时，如果name 为空，控制层并不会报错,也不会有报错提示
 *        需要在页面(view层)使用${}取值，才能进行相应的错误信息提示
 */
public class MyForm {

    @NotNull(message = "name not null")
    private String name;

    @Min(value = 0L, message = "min 0")
    @Max(value = 200, message = "max 200")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
