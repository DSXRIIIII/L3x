package cn.dsxriiiii.l3x.design.strategy;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.strategy
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 20:12
 * @Description: 加法策略
 **/
public class AdditionStrategy implements Strategy{
    @Override
    public int operate(int num1, int num2) {
        return num1 + num2;
    }
}
