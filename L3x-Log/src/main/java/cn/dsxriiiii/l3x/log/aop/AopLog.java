package cn.dsxriiiii.l3x.log.aop;

import cn.dsxriiiii.l3x.log.po.AppLog;
import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ProjectName: L3x-AopLog
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/29 17:37
 * @Email: lihh53453@hundsun.com
 */

@Aspect
@Component
@Slf4j
public class AopLog {
    @Pointcut("@annotation(cn.dsxriiiii.l3x.log.annotation.L3xLog)")
    public void log(){}
    @Around("log() && @annotation(cn.dsxriiiii.l3x.log.annotation.L3xLog)")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        //RequestContextHolder中获取当前的请求属性
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        // 打印请求相关参数
        long startTime = System.currentTimeMillis();
        Object result = point.proceed();

        AppLog l = AppLog.builder()
                .ip(getIp(request))
                .url(request.getRequestURL().toString())
                .httpMethod(request.getMethod())
                .requestParams(getNameAndValue(point))
                .result(result)
                .timeCost(System.currentTimeMillis() - startTime)
                .build();

        log.info("Request Log Info : {}", JSON.toJSONString(l));
        return result;
    }

    /**
     * 将请求的参数与入参对应并且返回
     * @param joinPoint ProceedingJoinPoint
     * @return 结果Map
     */
    private Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint) {
        // 获取JoinPoint对象的签名，它包含了方法的元数据信息
        final Signature signature = joinPoint.getSignature();
        // 将签名转换为MethodSignature类型，这是专门用于方法签名的类
        MethodSignature methodSignature = (MethodSignature) signature;
        // 获取方法参数的名称数组
        final String[] names = methodSignature.getParameterNames();
        // 获取方法参数的实际值数组
        final Object[] args = joinPoint.getArgs();

        // 检查参数名和参数值是否为空，如果为空则返回空Map
        if (ArrayUtil.isEmpty(names) || ArrayUtil.isEmpty(args)) {
            return Collections.emptyMap();
        }
        // 检查参数名和参数值的长度是否一致，如果不一致则记录警告并返回空Map
        if (names.length != args.length) {
            log.warn("{}方法参数名和参数值数量不一致", methodSignature.getName());
            return Collections.emptyMap();
        }
        // 创建一个HashMap来存储参数名和参数值的映射
        Map<String, Object> map = new HashMap<>();
        // 遍历参数名和参数值，将它们添加到Map中
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], args[i]);
        }
        // 返回包含参数名和参数值映射的Map
        return map;
    }

    private static final String UNKNOWN = "unknown";

    /**
     * 从Http请求中获取ip信息
     * @param request 请求体
     * @return ip地址
     */
    public static String getIp(HttpServletRequest request) {
        // 尝试从HTTP头"x-forwarded-for"获取IP地址
        String ip = request.getHeader("x-forwarded-for");
        // 如果获取的IP为空或者为"unknown"，则尝试从"Proxy-Client-IP"获取
        if (ip == null || ip.isEmpty() || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        // 如果获取的IP为空或者为"unknown"，则尝试从"WL-Proxy-Client-IP"获取
        if (ip == null || ip.isEmpty() || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        // 如果前面的尝试都失败了，则使用请求的远程地址作为IP
        if (ip == null || ip.isEmpty() || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 定义逗号字符串
        String comma = ",";
        // 定义本地主机地址
        String localhost = "127.0.0.1";
        // 如果IP地址包含逗号，取逗号前的部分作为真实的IP地址
        if (ip.contains(comma)) {
            ip = ip.split(",")[0];
        }
        // 如果IP地址是本地地址，则尝试获取本机真正的IP地址
        if (localhost.equals(ip)) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                log.error(e.getMessage(), e);
            }
        }
        // 返回最终获取的IP地址
        return ip;
    }

}
