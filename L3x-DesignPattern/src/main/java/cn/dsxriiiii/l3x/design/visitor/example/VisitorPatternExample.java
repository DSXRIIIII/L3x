package cn.dsxriiiii.l3x.design.visitor.example;

import cn.dsxriiiii.l3x.design.visitor.Element;
import cn.dsxriiiii.l3x.design.visitor.Visitor;
import cn.dsxriiiii.l3x.design.visitor.impl.ConcreteElementA;
import cn.dsxriiiii.l3x.design.visitor.impl.ConcreteElementB;
import cn.dsxriiiii.l3x.design.visitor.impl.ConcreteVisitor;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.visitor.example
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:21
 * @Description: 访问者模式
 * 访问者模式实际上就是把数据和对数据的访问解耦，数据的存储是一致的：
 * 论文发表数和分数，对数据的访问方式(是否获奖)却不同，因此使用访问者模式。
 **/
public class VisitorPatternExample {
    public static void main(String[] args) {
        Element elementA = new ConcreteElementA();
        Element elementB = new ConcreteElementB();

        Visitor visitor = new ConcreteVisitor();

        elementA.accept(visitor);
        elementB.accept(visitor);
    }
}
