package cn.web1992.utils.demo.command;

/**
 * Created by web1992 on 2016/8/29.
 *
 * @desc
 */
public class Invoker {
    Command command;

    public Invoker(Command command) {

        this.command = command;
    }

    public void action() {
        this.command.exe();
    }
    
}
