package udp.receiver;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import udp.sender.UdpSenderHandle;

public class UdpReceiverChannelInitializer extends ChannelInitializer<NioDatagramChannel> {

    EventExecutorGroup group = new DefaultEventExecutorGroup(16);
    @Override
    protected void initChannel(NioDatagramChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(group, new UdpReciverHandle());
    }
}
