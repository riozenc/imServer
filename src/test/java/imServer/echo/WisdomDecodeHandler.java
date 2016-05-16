/**
 * @Project:imServer
 * @Title:WisdomDecodeHandler.java
 * @Author:Riozenc
 * @Datetime:2016年5月16日 下午5:19:03
 */
package imServer.echo;

import java.nio.charset.Charset;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class WisdomDecodeHandler extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		// TODO Auto-generated method stub
		in.markReaderIndex();
		System.out.println(in.readInt());
		System.out.println(in.readInt());
		System.out.println(in.readInt());
		System.out.println(in.readInt());
		System.out.println(in.readInt());
		
		in.resetReaderIndex();
		
		if (in.readableBytes() < 84) {
			return;
		}


		byte[] packHead = new byte[84];
		in.readBytes(packHead);
		
		byte[] length = new byte[4];
		in.getBytes(16, length);
		
		
	
		
		
	

//		if (magicNumber != 'F') {
//			in.resetReaderIndex();
//			throw new Exception("Invalid magic number: " + magicNumber);
//		}

		// Wait until the whole data is available.
		int dataLength = in.readInt();
		if (in.readableBytes() < dataLength) {
			in.resetReaderIndex();
			return;
		}

		// Convert the received data into a new BigInteger.
		byte[] decoded = new byte[84+15];
		in.readBytes(decoded);

		System.out.println(decoded);
	}

}
