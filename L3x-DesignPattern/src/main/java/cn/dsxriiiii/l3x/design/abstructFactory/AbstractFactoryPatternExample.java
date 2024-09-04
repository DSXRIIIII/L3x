package cn.dsxriiiii.l3x.design.abstructFactory;

import cn.dsxriiiii.l3x.design.abstructFactory.factroy.AbstractFactory;
import cn.dsxriiiii.l3x.design.abstructFactory.factroy.ConcreteFactory1;
import cn.dsxriiiii.l3x.design.abstructFactory.factroy.ConcreteFactory2;
import cn.dsxriiiii.l3x.design.abstructFactory.product.ProductA;
import cn.dsxriiiii.l3x.design.abstructFactory.product.ProductB;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.abstructFactory
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/03 17:25
 * @Description: AbstractFactoryPatternExample
 **/
public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();
        productA1.useA();
        productB1.useB();

        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();
        productA2.useA();
        productB2.useB();
    }
}
