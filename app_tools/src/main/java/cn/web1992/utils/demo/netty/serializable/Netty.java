package cn.web1992.utils.demo.netty.serializable;

import java.io.Serializable;

/**
 * desc Netty 消息体
 * <p>
 * Version		1.0.0
 *
 * @author web1992
 * <p>
 * Date	      2018/11/14 10:40
 */
public class Netty implements Serializable {

    private static final long serialVersionUID = -9199521918444084448L;

    private String name;
    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
