package cn.web1992.utils.demo.netty.pipeline;


public class Ctx extends AbstractCtx {

    public Ctx() {
    }

    public Ctx(ChannelHandler channelHandler) {
        super(channelHandler);
    }

    @Override
    ChannelHandler handler() {
        return getChannelHandler();
    }
}
