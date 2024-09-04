package cn.dsxriiiii.l3x.design.abstructFactory.factroy;

import cn.dsxriiiii.l3x.design.abstructFactory.product.ConcreteProductA1;
import cn.dsxriiiii.l3x.design.abstructFactory.product.ConcreteProductB1;
import cn.dsxriiiii.l3x.design.abstructFactory.product.ProductA;
import cn.dsxriiiii.l3x.design.abstructFactory.product.ProductB;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.abstructFactory.factroy
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/03 17:22
 * @Description: ConcreteFactory1
 **/
public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}
