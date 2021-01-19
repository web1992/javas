package cn.web1992;

import java.lang.instrument.Instrumentation;

/**
 * @author web1992
 * @date 2021/1/19  11:39 上午
 */
public class Premain {
    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new DemoClassFileTransformer());
    }
}
