package cn.dsxriiiii.l3x.design.builder;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.builder
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:28
 * @Description: Director
 **/
public class Director {
    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}
