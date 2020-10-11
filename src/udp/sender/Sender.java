package udp.sender;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;

public class Sender {

    private EventLoopGroup group = new NioEventLoopGroup();
    private Bootstrap bootstrap = new Bootstrap();
    private InetSocketAddress inetSocketAddress;
    private Channel ch;

    public Sender(ChannelHandler handler) {
        bootstrap.group(group).channel(NioDatagramChannel.class).handler(handler);
    }

    public void run() throws Exception{
        try {
            this.ch = bootstrap.bind(0).sync().channel();
            this.ch.closeFuture().await();
        } finally {
            group.shutdownGracefully();
        }

    }




}
