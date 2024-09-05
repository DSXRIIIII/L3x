package cn.dsxriiiii.l3x.design.visitor.impl;

import cn.dsxriiiii.l3x.design.visitor.Visitor;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.visitor.impl
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:20
 * @Description: 具体的访问者
 **/
public class ConcreteVisitor implements Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA element) {
        element.operationA();
        System.out.println("ConcreteVisitor visited ConcreteElementA.");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB element) {
        element.operationB();
        System.out.println("ConcreteVisitor visited ConcreteElementB.");
    }
}
