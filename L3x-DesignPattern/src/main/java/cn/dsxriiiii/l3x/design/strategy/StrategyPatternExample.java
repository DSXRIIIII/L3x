package cn.dsxriiiii.l3x.design.strategy;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.strategy
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 20:24
 * @Description: 策略模式实现类
 **/
public class StrategyPatternExample {
    public static void main(String[] args) {
        Context contextAdd = new Context(new AdditionStrategy());
        int resultAdd = contextAdd.executeStrategy(10, 5);
        System.out.println("加法结果：" + resultAdd);

        Context contextSubtract = new Context(new SubtractionStrategy());
        int resultSubtract = contextSubtract.executeStrategy(10, 5);
        System.out.println("减法结果：" + resultSubtract);
    }
}
