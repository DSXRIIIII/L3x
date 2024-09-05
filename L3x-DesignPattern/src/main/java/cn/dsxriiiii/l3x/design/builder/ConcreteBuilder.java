package cn.dsxriiiii.l3x.design.builder;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.builder
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:28
 * @Description: ConcreteBuilder
 **/
public class ConcreteBuilder implements Builder {
    private Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    public void buildPartA() {
        product.setPartA("Part A of ConcreteBuilder");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Part B of ConcreteBuilder");
    }

    @Override
    public void buildPartC() {
        product.setPartC("Part C of ConcreteBuilder");
    }

    @Override
    public Product getResult() {
        return product;
    }
}