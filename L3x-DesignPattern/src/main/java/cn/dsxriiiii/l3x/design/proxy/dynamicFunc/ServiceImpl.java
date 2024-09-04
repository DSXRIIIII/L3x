package cn.dsxriiiii.l3x.design.proxy.dynamicFunc;

/**
 * @PackageName: PACKAGE_NAME
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/26 19:44
 * @Description: 实现服务
 **/
public class ServiceImpl implements Service {
    @Override
    public void doSomething() {
        System.out.println("我是动态代理の实现类doSomething(∪.∪ )...zzz");
    }

    @Override
    public void checkSomething() {
        System.out.println("我是动态代理の实现类checkSomething(∪.∪ )...zzz");
    }
}
