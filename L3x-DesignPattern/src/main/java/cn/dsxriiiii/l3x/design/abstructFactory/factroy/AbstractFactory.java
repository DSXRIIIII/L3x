package cn.dsxriiiii.l3x.design.abstructFactory.factroy;

import cn.dsxriiiii.l3x.design.abstructFactory.product.ProductA;
import cn.dsxriiiii.l3x.design.abstructFactory.product.ProductB;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.abstructFactory.factroy
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/03 17:21
 * @Description: AbstractFactory
 **/
public interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}
