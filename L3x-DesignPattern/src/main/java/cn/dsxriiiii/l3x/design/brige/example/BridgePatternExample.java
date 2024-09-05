package cn.dsxriiiii.l3x.design.brige.example;

import cn.dsxriiiii.l3x.design.brige.*;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.brige
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:14
 * @Description: 桥接模式
 * 桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。
 * 这种类型的设计模式属于结构型模式，它通过提供抽象化和实现化之间的桥接结构，来实现二者的解耦。
 * 将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低 抽象和实现这两个可变维度的耦合度。
 **/
public class BridgePatternExample {
    public static void main(String[] args) {
        Implementor implementorA = new ConcreteImplementorA();
        Abstraction abstractionWithA = new RefinedAbstraction(implementorA);
        abstractionWithA.operation();

        Implementor implementorB = new ConcreteImplementorB();
        Abstraction abstractionWithB = new RefinedAbstraction(implementorB);
        abstractionWithB.operation();
    }
}
