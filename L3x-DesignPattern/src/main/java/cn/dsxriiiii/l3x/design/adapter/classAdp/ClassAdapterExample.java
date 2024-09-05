package cn.dsxriiiii.l3x.design.adapter.classAdp;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.adapter
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/03 17:36
 * @Description: 类适配器
 * 将一个类的接口转换成客户希望的另一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
 **/
public class ClassAdapterExample {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
