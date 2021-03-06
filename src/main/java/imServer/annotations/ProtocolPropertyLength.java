/**
 * @Title:CharacterLength.java
 * @author:Riozenc
 * @datetime:2015年5月28日 下午6:18:04
 */
package imServer.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProtocolPropertyLength {
	int value();
}
