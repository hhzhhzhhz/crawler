import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import udp.sender.Sender;
import udp.sender.UdpSenderChannelInitializer;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class main {

    public static void main(String[] args) throws Exception{

//        EventLoopGroup group = new NioEventLoopGroup();
//        try {
//            Bootstrap b = new Bootstrap();
//            b.group(group).channel(NioDatagramChannel.class)
//                    .handler(new MyChannelInitializer()).connect("127.0.0.1",8080);
//            Channel ch = b.bind(0).sync().channel();
//            //向目标端口发送信息
//            ch.closeFuture().await();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            group.shutdownGracefully();
//        }
        new Sender(new UdpSenderChannelInitializer(new InetSocketAddress("127.0.0.1", 8081))).run();

    }
}
