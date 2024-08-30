package cn.dsxriiiii.L3x.dynamicSwitch.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @PackageName: cn.dsxriiiii.l3x.log.annotation
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/29 17:08
 * @Description: 开关
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Switch {
    String value() default "";
}
