package cn.web1992.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by web1992 on 2016/8/9.
 *
 * @desc
 */
@Service("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

    Logger logger= LoggerFactory.getLogger(HelloWorldServiceImpl.class);

    @Override
    public void sayHello() {
        logger.info("hello");
    }

    @Override
    public String sayHi() {
        return "Hi";
    }
}
