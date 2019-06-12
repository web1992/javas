package cn.web1992.utils.demo.netty.pipeline;


public abstract class AbstractCtx {

    volatile AbstractCtx next;

    volatile AbstractCtx prev;

    private ChannelHandler channelHandler;


    public AbstractCtx() {
    }

    public AbstractCtx(ChannelHandler channelHandler) {
        this.channelHandler = channelHandler;
    }

    public static void invoke(AbstractCtx ctx) {
        if (null != ctx) {
            ctx.fired(ctx);
        }
    }

    public void invoke() {
        invoke(findNextCtx());
    }

    private AbstractCtx findNextCtx() {
        AbstractCtx ctx = this;
        return ctx.next;
    }

    private void fired(AbstractCtx ctx) {
        ctx.handler().write(this);
    }

    public ChannelHandler getChannelHandler() {
        return channelHandler;
    }

    abstract ChannelHandler handler();
}
