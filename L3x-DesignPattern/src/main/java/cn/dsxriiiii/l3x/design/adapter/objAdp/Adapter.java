package cn.dsxriiiii.l3x.design.adapter.objAdp;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.adapter.objAdp
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 16:20
 * @Description: Adapter
 **/
public class Adapter implements Target{
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
