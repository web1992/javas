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

    public static void invoke(AbstractCtx ctx,Object obj) {
        if (null != ctx) {
            ctx.fired(ctx,obj);
        }
    }

    public void invoke(Object obj) {
        invoke(findNextCtx(), obj);
    }

    private AbstractCtx findNextCtx() {
        AbstractCtx ctx = this;
        return ctx.next;
    }

    private void fired(AbstractCtx ctx,Object obj) {
        ctx.handler().write(this, obj);
    }

    public ChannelHandler getChannelHandler() {
        return channelHandler;
    }

    abstract ChannelHandler handler();
}
