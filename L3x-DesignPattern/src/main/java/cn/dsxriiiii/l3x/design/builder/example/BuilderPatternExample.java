package cn.dsxriiiii.l3x.design.builder.example;

import cn.dsxriiiii.l3x.design.builder.Builder;
import cn.dsxriiiii.l3x.design.builder.ConcreteBuilder;
import cn.dsxriiiii.l3x.design.builder.Director;
import cn.dsxriiiii.l3x.design.builder.Product;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.builder.example
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:29
 * @Description: 建造者模式
 **/
public class BuilderPatternExample {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director();
        director.construct(builder);
        Product product = builder.getResult();
        product.show();
    }
}
