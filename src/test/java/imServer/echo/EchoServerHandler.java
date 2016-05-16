/**
 * @Project:imServer
 * @Title:EchoServerHandler.java
 * @Author:Riozenc
 * @Datetime:2016年5月11日 下午2:30:35
 */
package imServer.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Handler implementation for the echo server.
 */
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server channelActive");
		super.channelActive(ctx);
	}

	/**
	 * 无效
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server channelInactive");
		super.channelInactive(ctx);
	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server channelRegistered");
		super.channelRegistered(ctx);
	}

	/**
	 * 断开？
	 */
	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server channelUnregistered");
		super.channelUnregistered(ctx);
	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Server channelWritabilityChanged");
		super.channelWritabilityChanged(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		 ByteBuf in = (ByteBuf) msg;
		    try {
		    	System.out.println(in.toString(io.netty.util.CharsetUtil.UTF_8));
		    } finally {
		        ReferenceCountUtil.release(msg); // (2)
		    }
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		System.out.println("Server channelReadComplete");
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		// Close the connection when an exception is raised.
		cause.printStackTrace();
		ctx.close();
	}
}
