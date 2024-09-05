package cn.dsxriiiii.l3x.design.visitor;

import cn.dsxriiiii.l3x.design.visitor.impl.ConcreteElementA;
import cn.dsxriiiii.l3x.design.visitor.impl.ConcreteElementB;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.visitor
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:18
 * @Description: Visitor
 **/
public interface Visitor {
    void visitConcreteElementA(ConcreteElementA element);
    void visitConcreteElementB(ConcreteElementB element);
}
