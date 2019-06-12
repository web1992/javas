package cn.web1992.utils.demo.netty.pipeline;


public class PipeLineMain {
    public static void main(String[] args) {

        PipeLine pipeLine = new PipeLine();

        pipeLine.addFirst(new ChannelHandlerAA());
        pipeLine.addFirst(new ChannelHandlerBB());
        pipeLine.addFirst(new ChannelHandlerCC());

        pipeLine.fire("pipeline");

    }
}

class ChannelHandlerAA implements ChannelHandler {

    @Override
    public void write(AbstractCtx ctx, Object obj) {
        System.out.println(this.getClass().getSimpleName());
        ctx.invoke(obj);
    }
}


class ChannelHandlerBB implements ChannelHandler {

    @Override
    public void write(AbstractCtx ctx, Object obj) {
        System.out.println(this.getClass().getSimpleName());
        ctx.invoke(obj);
    }
}

class ChannelHandlerCC implements ChannelHandler {

    @Override
    public void write(AbstractCtx ctx, Object obj) {
        System.out.println(this.getClass().getSimpleName());
        ctx.invoke(obj);
    }
}

