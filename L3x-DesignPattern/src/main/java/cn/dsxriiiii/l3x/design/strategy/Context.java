package cn.dsxriiiii.l3x.design.strategy;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.strategy
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 20:23
 * @Description: 上下文 用于封装策略
 **/
class Context {
    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.operate(num1, num2);
    }
}