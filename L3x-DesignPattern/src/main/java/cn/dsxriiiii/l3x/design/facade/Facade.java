package cn.dsxriiiii.l3x.design.facade;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.facade
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:34
 * @Description: Facade
 **/
public class Facade {
    private SubSystemA subSystemA;
    private SubSystemB subSystemB;
    private SubSystemC subSystemC;

    public Facade() {
        subSystemA = new SubSystemA();
        subSystemB = new SubSystemB();
        subSystemC = new SubSystemC();
    }

    public void operation() {
        subSystemA.operationA();
        subSystemB.operationB();
        subSystemC.operationC();
    }
}
