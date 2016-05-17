/**
 * @Project:imServer
 * @Title:BaseProtocolEntity.java
 * @Author:Riozenc
 * @Datetime:2016年5月17日 上午11:50:45
 */
package imServer.msgbox.protocol;

import java.lang.reflect.Field;

import com.riozenc.quicktool.common.util.annotation.FieldAnnotationUtil;

import imServer.annotations.CharacterLength;
import imServer.annotations.ProtocolPropertyLength;

public class BaseProtocolEntity {
	private static int HEAD_LENGTH;
	private static int DATA_INDEX;

	protected int getDataIndex() {
		return DATA_INDEX;
	}

	protected int getRealHeadLength() {
		return getRealHeadLength(false);
	}

	protected int getRealHeadLength(boolean isFlush) {
		if (HEAD_LENGTH == 0 || isFlush) {
			Field[] fields = getClass().getDeclaredFields();
			for (Field field : fields) {
				if (null != field.getAnnotation(ProtocolPropertyLength.class)) {
					// len
					DATA_INDEX = HEAD_LENGTH;
				}
				HEAD_LENGTH += (int) FieldAnnotationUtil.getAnnotation(field, CharacterLength.class);
			}
		}
		return HEAD_LENGTH;
	}
}
