package cn.dsxriiiii.l3x.design.decorator;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.decorator
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 16:59
 * @Description: ConcreteDecoratorA
 **/
public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("Added behavior B.");
    }
}
