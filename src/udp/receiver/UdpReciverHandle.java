package udp.receiver;

import com.google.protobuf.InvalidProtocolBufferException;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;


public class UdpReciverHandle extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) {

        try {
            byte[] bytes = new byte[packet.content().readableBytes()];
            packet.content().readBytes(bytes);


            message.Message.Package recv = message.Message.Package.parseFrom(bytes);
            System.out.println(recv.toString());
        }catch (InvalidProtocolBufferException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        super.channelReadComplete(ctx);
//        ctx.close();
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
