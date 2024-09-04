package cn.dsxriiiii.l3x.design.abstructFactory.factroy;

import cn.dsxriiiii.l3x.design.abstructFactory.product.*;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.abstructFactory.factroy
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/03 17:24
 * @Description: ConcreteFactory2
 **/
public class ConcreteFactory2 implements AbstractFactory{
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}
