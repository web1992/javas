package cn.web1992.utils.demo.java8;

import org.apache.commons.lang.StringUtils;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author web1992
 * @date 2017/2/15 13:57
 * @desc
 */
public class LambdaService {


    public static void main(String[] args) {

        LambdaService service = new LambdaService();

        Consumer<String> consumer = (String s) -> System.out.println(s);
        Consumer<String> consumer2 = (String s) -> System.out.println("then "+s);

        consumer.andThen(consumer2).accept("run ");


    }


    public boolean process(LambdaReq req) {

        Optional<LambdaReq> reqOptional = Optional.of(req);


        reqOptional
                .filter((LambdaReq s) -> StringUtils.isNotBlank(s.getAge()))
                .map(r -> r.getAge())
                .map(s -> String.valueOf(s))
                .orElse(null);


        Consumer<String> consumer = (String s) -> System.out.println(s);
        consumer.accept("1");

        return false;
    }


}


class LambdaReq {

    private String name;
    private String age;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}


