/**
 * @Project:imServer
 * @Title:ProtocolCheckException.java
 * @Author:Riozenc
 * @Datetime:2016年5月17日 下午2:20:43
 */
package imServer.exception.netty.msgbox;

import com.riozenc.quicktool.common.util.log.ExceptionLogUtil;
import com.riozenc.quicktool.common.util.log.LogUtil;
import com.riozenc.quicktool.common.util.log.LogUtil.LOG_TYPE;

public class ProtocolCheckException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5505952963621815641L;

	public ProtocolCheckException() {
		super();
	}

	public ProtocolCheckException(String message) {
		super(message);
		// 数据初始化日志记录

		LogUtil.getLogger(LOG_TYPE.IO).error(message + ExceptionLogUtil.log(this));

	}

	public ProtocolCheckException(Throwable cause) {
		super(cause);
	}

	public ProtocolCheckException(String message, Throwable cause) {
		super(message, cause);
	}
}
