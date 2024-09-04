package cn.dsxriiiii.l3x.design.proxy.dynamicFunc;

import java.lang.reflect.Proxy;

/**
 * @PackageName: cn.dsxriiiii.L3x.Proxy.dynamicFunc
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/26 19:58
 * @Description: 动态代理实例演示
 * 动态代理和静态代理的区别：
 * 1.动态代理运行时生成字节码文件加载到JVM  静态代理编译时实现
 * 2.当接口新填新的方法时 静态代理实现类和代理类都需要修改
 **/
public class DynamicProxyMain {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        Service proxy = (Service) Proxy.newProxyInstance(
                //指定类加载器
                service.getClass().getClassLoader(),
                //指定代理实现接口
                service.getClass().getInterfaces(),
                //代理对象要做的事情
                new DynamicProxyService(service));
        proxy.doSomething();
        proxy.checkSomething();
    }
}
