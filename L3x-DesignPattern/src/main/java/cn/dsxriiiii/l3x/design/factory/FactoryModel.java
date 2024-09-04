package cn.dsxriiiii.l3x.design.factory;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.factory
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/03 17:13
 * @Description: 工厂模式设计场景
 **/
public class FactoryModel {
    public static void main(String[] args) {
        FactoryDesign.Factory factoryA = new FactoryDesign.ConcreteFactoryA();
        ProductDesign.Product productA = factoryA.createProduct();
        productA.use();

        FactoryDesign.Factory factoryB = new FactoryDesign.ConcreteFactoryB();
        ProductDesign.Product productB = factoryB.createProduct();
        productB.use();
    }
}
