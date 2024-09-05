package cn.dsxriiiii.l3x.design.brige;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.brige
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:13
 * @Description: 抽象化角色
 **/
public abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}
