/**
 * @Project:imServer
 * @Title:ProtocolHeadPackage.java
 * @Author:Riozenc
 * @Datetime:2016年5月17日 上午8:46:13
 */
package imServer.echo;

import imServer.annotations.CharacterLength;
import imServer.annotations.ProtocolPropertyLength;
import imServer.msgbox.protocol.BaseProtocolEntity;

/**
 * 协议头
 * 
 * @author Czy
 *
 */
public class ProtocolHeadPackage extends BaseProtocolEntity {
	@CharacterLength(4)
	private int bs;// 4
	@CharacterLength(4)
	private int ver;// 4
	@CharacterLength(4)
	private int cmd;// 4
	@CharacterLength(4)
	private int key;// 4
	@ProtocolPropertyLength(4)
	@CharacterLength(4)
	private int len;// 4
	@CharacterLength(4)
	private int len2;// 4
	@CharacterLength(64)
	private byte[] uid = new byte[64];// 64

	private String message;

	public ProtocolHeadPackage() {

	}

	public int getHeadLength() {
		return getRealHeadLength();
	}

	public int getDataIndex() {
		return super.getDataIndex();
	}

	public int getBs() {
		return bs;
	}

	public void setBs(int bs) {
		this.bs = bs;
	}

	public int getVer() {
		return ver;
	}

	public void setVer(int ver) {
		this.ver = ver;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public int getLen2() {
		return len2;
	}

	public void setLen2(int len2) {
		this.len2 = len2;
	}

	public byte[] getUid() {
		return uid;
	}

	public void setUid(byte[] uid) {
		this.uid = uid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
