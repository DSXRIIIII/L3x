package cn.dsxriiiii.l3x.design.flyweight.example;

import cn.dsxriiiii.l3x.design.flyweight.Flyweight;
import cn.dsxriiiii.l3x.design.flyweight.FlyweightFactory;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.flyweight.example
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:47
 * @Description: 享元模式
 * 享元模式主要用于减少创建对象的数量，以减少内存占用和提高性能
 * 很多网络设备都是支持共享的，如交换机、集线器等，多台终端计算机可以连接同一台网络设备，并通过该网络设备进行数据转发。
 **/
public class flyweightExample {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("key1");
        flyweight1.operation("extrinsic state 1");

        Flyweight flyweight2 = factory.getFlyweight("key1");
        flyweight2.operation("extrinsic state 2");

        Flyweight flyweight3 = factory.getFlyweight("key2");
        flyweight3.operation("extrinsic state 3");
    }
}
