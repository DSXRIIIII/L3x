package cn.dsxriiiii.l3x.design.decorator;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.decorator
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 16:57
 * @Description: ConcreteComponent
 **/
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("Executing operation in ConcreteComponent.");
    }
}