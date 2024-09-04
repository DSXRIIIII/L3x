package cn.dsxriiiii.l3x.design.proxy.staticFunc;

/**
 * @PackageName: staticProxy
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/26 19:46
 * @Description: 静态代理类
 **/
public class ServiceProxy implements Service{
    private final Service instance;
    public ServiceProxy(Service instance){
        this.instance = instance;
    }
    @Override
    public void doSomething() {
        System.out.println("静态代理类接管，操作前处理");
        instance.doSomething();
        System.out.println("静态代理类接管，操作后处理");
    }
}
