package udp.receiver;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class Receiver {

    private EventLoopGroup group = new NioEventLoopGroup();
    private Bootstrap bootstrap = new Bootstrap();
    private int port;

    public Receiver(int port, ChannelHandler handler) {
        this.port = port;
        bootstrap
                .group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST,true)
                .handler(handler);

    }

    public void run() throws Exception {
        try {
            bootstrap.bind(port).sync().channel().closeFuture().await();
        } finally {
            group.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception{
        new Receiver(8081, new UdpReceiverChannelInitializer()).run();

    }
}
