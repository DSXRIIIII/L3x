package cn.dsxriiiii.l3x.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: L3x-AopLog
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/29 17:35
 * @Email: lihh53453@hundsun.com
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface L3xLog {
}
