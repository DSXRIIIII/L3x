package cn.dsxriiiii.l3x.design.visitor;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.visitor
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:18
 * @Description: Element
 **/
public interface Element {
    void accept(Visitor visitor);
}
