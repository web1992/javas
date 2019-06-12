package cn.web1992.utils.demo.netty.pipeline;

/**
 * PipeLine -> Ctx.head ->Ctx.invoke -> Ctx.findOne -> Ctx.ChannelHandler -> Ctx
 */
public class PipeLine {
    private AbstractCtx head;
    private AbstractCtx tail;


    public PipeLine() {
        // init
        head = new HeadCtx();
        tail = new TailCtx();
        // set chain
        head.next = tail;
        tail.prev = head;
    }

    public void fire() {
        AbstractCtx.invoke(head);
    }

    public void addFirst(ChannelHandler channelHandler) {
        synchronized (this) {
            AbstractCtx newCtx = createCtx(channelHandler);
            addFirst0(newCtx);
        }
    }

    private AbstractCtx createCtx(ChannelHandler channelHandler) {
        Ctx ctx = new Ctx(channelHandler);
        return ctx;
    }

    private void addFirst0(AbstractCtx newCtx) {
        AbstractCtx nextCtx = head.next;
        newCtx.prev = head;
        newCtx.next = nextCtx;
        head.next = newCtx;
        nextCtx.prev = newCtx;
    }


    static class TailCtx extends AbstractCtx implements ChannelHandler {


        @Override
        ChannelHandler handler() {
            return this;
        }

        @Override
        public void write(AbstractCtx ctx) {
            System.out.println(this.getClass().getSimpleName());
            ctx.invoke();
        }
    }

    static class HeadCtx extends AbstractCtx implements ChannelHandler {

        @Override
        ChannelHandler handler() {
            return this;
        }

        @Override
        public void write(AbstractCtx ctx) {
            System.out.println(this.getClass().getSimpleName());
            ctx.invoke();
        }
    }

}

