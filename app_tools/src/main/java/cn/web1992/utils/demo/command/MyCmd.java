package cn.web1992.utils.demo.command;

/**
 * Created by web1992 on 2016/8/29.
 *
 * @desc
 */
public class MyCmd implements Command {


    Receiver receiver;

    public MyCmd(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        this.receiver.action();
    }


}
