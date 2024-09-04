package cn.dsxriiiii.l3x.design.factory;

/**
 * @PackageName: cn.dsxriiiii.l3x
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/03 17:06
 * @Description: 工厂模式
 **/
public class FactoryDesign {
    interface Factory {
        ProductDesign.Product createProduct();
    }
    static class ConcreteFactoryA implements Factory {
        @Override
        public ProductDesign.Product createProduct() {
            return new ProductDesign.ConcreteProductA();
        }
    }

    static class ConcreteFactoryB implements Factory {
        @Override
        public ProductDesign.Product createProduct() {
            return new ProductDesign.ConcreteProductB();
        }
    }
}
