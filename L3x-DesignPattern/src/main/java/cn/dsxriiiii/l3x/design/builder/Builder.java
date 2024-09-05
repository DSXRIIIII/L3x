package cn.dsxriiiii.l3x.design.builder;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.builder
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:28
 * @Description: Builder
 **/
public interface Builder {
    void buildPartA();
    void buildPartB();
    void buildPartC();
    Product getResult();
}
