package udp.sender;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.DatagramPacket;

import java.net.InetSocketAddress;

public class UdpSenderHandle extends ChannelInboundHandlerAdapter {

    private InetSocketAddress inetSocketAddress;

    public UdpSenderHandle(InetSocketAddress inetSocketAddress){
        this.inetSocketAddress = inetSocketAddress;

    }

    //接受服务端发送的内容
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("接收");
        super.channelRead(ctx, msg);

        System.out.println(msg.toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        message.Message.Package msg = message.Message.Package.newBuilder().setCallback("http").setTaskId(String.valueOf(1)).setTimestamp(1111l).addSource("127.0.0.1.1").setAttributes(message.Message.Package.ATTRIBUTES.HEARTBEAT).build();
        while (true) {
            Thread.sleep(2000);
            ctx.channel().writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer(msg.toByteArray()),
                    inetSocketAddress)).sync();
        }

    }
}
