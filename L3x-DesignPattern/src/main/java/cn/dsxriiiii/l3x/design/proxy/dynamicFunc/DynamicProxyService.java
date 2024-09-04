package cn.dsxriiiii.l3x.design.proxy.dynamicFunc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @PackageName: cn.dsxriiiii.L3x.Proxy.dynamicFunc
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/26 19:54
 * @Description: 动态代理实现
 **/
public class DynamicProxyService implements InvocationHandler {
    private final Object target;

    public DynamicProxyService(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理实现类执行操作 before");
        System.out.println("动态代理方法名称：" + method.getName());
        Object invoke = method.invoke(target, args);
        System.out.println("动态代理实现类执行操作 after");
        return invoke;
    }
}
