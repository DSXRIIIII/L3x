package cn.dsxriiiii.l3x.design.decorator;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.decorator
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 16:58
 * @Description: 装饰器
 **/
public abstract class Decorator implements Component{
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
