package cn.dsxriiiii.l3x.design.brige;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.brige
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:14
 * @Description: 拓展抽象化角色
 **/
public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        System.out.println("Refined Abstraction operation.");
        implementor.operationImpl();
    }
}
