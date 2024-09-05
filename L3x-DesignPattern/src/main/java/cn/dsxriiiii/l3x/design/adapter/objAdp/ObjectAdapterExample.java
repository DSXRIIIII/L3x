package cn.dsxriiiii.l3x.design.adapter.objAdp;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.adapter.objAdp
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 16:21
 * @Description: ObjectAdapterExample
 * 适配器模式：主要目的是将一个类的接口转换成客户希望的另外一个接口
 * 使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。它侧重于接口的转换。
 * 将一个类的接口转换成客户希望的另一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
 **/
public class ObjectAdapterExample {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.request();
    }
}