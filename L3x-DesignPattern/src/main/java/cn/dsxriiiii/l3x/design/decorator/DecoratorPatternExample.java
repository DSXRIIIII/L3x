package cn.dsxriiiii.l3x.design.decorator;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.decorator
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 17:00
 * @Description: DecoratorPatternExample
 * 如果你希望在无需修改代码的情况下即可使⽤对象， 且希望在运行时为对
 * 象新增额外的行为， 可以使用装饰模式。
 **/
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component decoratedComponentA = new ConcreteDecoratorA(component);
        Component decoratedComponentB = new ConcreteDecoratorB(decoratedComponentA);
        decoratedComponentB.operation();
    }
}
