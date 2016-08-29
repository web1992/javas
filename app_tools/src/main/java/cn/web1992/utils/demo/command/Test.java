package cn.web1992.utils.demo.command;

/**
 * Created by web1992 on 2016/8/29.
 *
 * @desc 命令行模式 实现命令的生成 与 执行 的分离
 *
 *
 */
public class Test {

    public static void main(String[] args) {

        Receiver receiver = new Receiver();

        Command command = new MyCmd(receiver);


        Invoker invoker = new Invoker(command);

        invoker.action();
    }

}
