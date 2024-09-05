package cn.dsxriiiii.l3x.design.builder;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.builder
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:27
 * @Description: Product
 **/
public class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        System.out.println("Part A: " + partA);
        System.out.println("Part B: " + partB);
        System.out.println("Part C: " + partC);
    }
}
