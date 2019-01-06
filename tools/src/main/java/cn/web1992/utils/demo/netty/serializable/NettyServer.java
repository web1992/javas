package cn.web1992.utils.demo.netty.serializable;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ObjectDecoder;

import java.net.InetSocketAddress;

/**
 * desc: NettyServer
 * <p>
 * Version		1.0.0
 *
 * @author web1992
 * <p>
 * Date	      2018/11/14 10:25
 */
public class NettyServer {
    public static void main(String[] args) {
        new NettyServer().bootstrap();
    }

    /**
     * 启动server
     */
    public void bootstrap() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializerImpl());
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8081));

        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    System.out.println("Server bound");
                } else {
                    System.err.println("Bind attempt failed");
                    channelFuture.cause().printStackTrace();
                }
            }
        });
    }

    /**
     * 自定义的Handler 主要处理业务逻辑
     */
    final class NettyHandler extends SimpleChannelInboundHandler<Netty> {
        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, Netty netty) throws Exception {
            System.out.println("Received data： " + netty.getName() + ", version is  " + netty.getVersion());
        }
    }

    /**
     * 负责pipeline的组装
     */
    final class ChannelInitializerImpl extends ChannelInitializer<Channel> {
        @Override
        protected void initChannel(Channel ch) throws Exception {
            ChannelPipeline pipeline = ch.pipeline();
            // ObjectDecoder 负责把 byte 转化成 java 对象
            pipeline.addLast(new ObjectDecoder(new MyClassResolver()));
            // NettyHandler 处理业务逻辑
            pipeline.addLast(new NettyHandler());
        }
    }

    /**
     * 自定义类加载器
     */
    final class MyClassResolver implements ClassResolver {

        @Override
        public Class<?> resolve(String className) throws ClassNotFoundException {

            ClassLoader classLoader = MyClassResolver.class.getClassLoader();

            try {
                return classLoader.loadClass(className);
            } catch (ClassNotFoundException ignored) {
                return Class.forName(className, false, classLoader);
            }
        }
    }

}
