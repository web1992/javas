package cn.web1992.utils.demo.netty.serializable;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.io.Serializable;
import java.net.InetSocketAddress;

/**
 * desc: NettyClient
 * <p>
 * Version		1.0.0
 *
 * @author web1992
 * <p>
 * Date	      2018/11/14 10:25
 */
public class NettyClient {
    public static void main(String args[]) {
        NettyClient client = new NettyClient();
        client.bootstrap();
    }

    /**
     * 启动client
     */
    public void bootstrap() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializerImpl());
        ChannelFuture future = bootstrap.connect(new InetSocketAddress("127.0.0.1", 8081));
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    System.out.println("Connection established");
                    // send msg
                    Channel channel = channelFuture.channel();
                    Netty netty = new Netty();
                    netty.setName("I am netty");
                    netty.setVersion("4.1.31.Final");
                    // write 只是把数据写入缓存，不一定会写入socket
                    // writeAndFlush 写入&发送
                    ChannelFuture write = channel.writeAndFlush(netty);
                    if (write.isSuccess()) {
                        System.out.println("write msg suc");
                    }
                } else {
                    System.err.println("Connection attempt failed");
                    channelFuture.cause().printStackTrace();
                }
            }
        });


    }

    /**
     * 负责pipeline的组装
     */
    final class ChannelInitializerImpl extends ChannelInitializer<Channel> {
        @Override
        protected void initChannel(Channel ch) throws Exception {
            ChannelPipeline pipeline = ch.pipeline();
            pipeline.addLast(new ObjectEncoder());
            //pipeline.addLast(new ClazzToByteEncoder());
        }
    }

    /**
     * 自定义Encoder
     */
    final class ClazzToByteEncoder extends ObjectEncoder {
        @Override
        protected void encode(ChannelHandlerContext ctx, Serializable msg, ByteBuf out) throws Exception {
            super.encode(ctx, msg, out);
        }
    }

}
