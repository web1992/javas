/**
 * 文件名称:          	Person
 * 版权所有@ 2017-2018 	魔谐(上海)软件有限公司，保留所有权利
 * 编译器:           	JDK1.8
 */

package cn.web1992.utils.demo.seriablize;

import java.io.Serializable;

/**
 * TODO: 文件注释
 * <p>
 * Version		1.0.0
 *
 * @author wangerbao
 * <p>
 * Date	      2018/11/12 18:25
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -2509393341676544266L;
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
