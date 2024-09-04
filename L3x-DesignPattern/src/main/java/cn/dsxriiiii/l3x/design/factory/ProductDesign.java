package cn.dsxriiiii.l3x.design.factory;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.factory
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/03 17:09
 * @Description: 产品
 **/
public class ProductDesign {
    interface Product {
        void use();
    }
    static class ConcreteProductA implements Product {
        @Override
        public void use() {
            System.out.println("Using ConcreteProductA");
        }
    }

    static class ConcreteProductB implements Product {
        @Override
        public void use() {
            System.out.println("Using ConcreteProductB");
        }
    }
}
