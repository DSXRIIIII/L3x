package cn.dsxriiiii.l3x.design.visitor.impl;

import cn.dsxriiiii.l3x.design.visitor.Element;
import cn.dsxriiiii.l3x.design.visitor.Visitor;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.visitor.impl
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:20
 * @Description: ConcreteElementB
 **/
public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }

    public void operationB() {
        System.out.println("ConcreteElementB operation.");
    }
}
