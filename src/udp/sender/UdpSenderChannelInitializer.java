package udp.sender;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;

public class UdpSenderChannelInitializer extends ChannelInitializer<NioDatagramChannel> {

    private EventLoopGroup group = new NioEventLoopGroup();
    private InetSocketAddress inetSocketAddress;

    public UdpSenderChannelInitializer(InetSocketAddress inetSocketAddress) {
        this.inetSocketAddress = inetSocketAddress;

    }

    @Override
    protected void initChannel(NioDatagramChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(group, new UdpSenderHandle(this.inetSocketAddress));
    }

}
