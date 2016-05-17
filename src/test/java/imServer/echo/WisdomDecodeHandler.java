/**
 * @Project:imServer
 * @Title:WisdomDecodeHandler.java
 * @Author:Riozenc
 * @Datetime:2016年5月16日 下午5:19:03
 */
package imServer.echo;

import java.util.List;

import imServer.exception.netty.msgbox.ProtocolCheckException;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class WisdomDecodeHandler extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		// TODO Auto-generated method stub

		ProtocolHeadPackage protocolHeadPackage = new ProtocolHeadPackage();

		// 是否满足headpackeg的长度要求
		System.out.println(protocolHeadPackage.getHeadLength());
		if (in.readableBytes() < protocolHeadPackage.getHeadLength()) {
			return;
		}

		checkHead(in, protocolHeadPackage);// 校验并赋值

		// 判断完整数据的长度
		if (in.readableBytes() < protocolHeadPackage.getHeadLength() + protocolHeadPackage.getLen()) {
			return;
		}

		byte[] data = new byte[protocolHeadPackage.getLen()];
		in.readBytes(data);

		// protocolHeadPackage.setMessage(message);

		System.out.println(new String(data));
	}

	private void checkHead(ByteBuf in, ProtocolHeadPackage protocolHeadPackage) throws ProtocolCheckException {
		in.markReaderIndex();// 标记位置，用于重新读取完整数据。

		// 进行校验
		int bs = in.readIntLE();

		if (bs != '1') {
			in.resetReaderIndex();
			throw new ProtocolCheckException("Invalid bs number: " + bs);
		}

		int ver = in.readIntLE();
		if (ver != '0') {
			in.resetReaderIndex();
			throw new ProtocolCheckException("Invalid ver number: " + ver);
		}

		protocolHeadPackage.setBs(bs);
		protocolHeadPackage.setVer(ver);
		protocolHeadPackage.setCmd(in.readIntLE());
		protocolHeadPackage.setKey(in.readIntLE());
		protocolHeadPackage.setLen(in.readIntLE());
		protocolHeadPackage.setLen2(in.readIntLE());
		in.getBytes(0, protocolHeadPackage.getUid());

	}

}
