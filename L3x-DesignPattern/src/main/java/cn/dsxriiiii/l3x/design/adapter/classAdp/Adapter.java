package cn.dsxriiiii.l3x.design.adapter.classAdp;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.adapter
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/03 17:34
 * @Description: Adapter
 **/
class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.specificRequest();
    }
}
