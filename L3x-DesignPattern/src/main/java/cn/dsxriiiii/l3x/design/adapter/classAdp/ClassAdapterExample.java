package cn.dsxriiiii.l3x.design.adapter.classAdp;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.adapter
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/03 17:36
 * @Description: 类适配器
 **/
public class ClassAdapterExample {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
