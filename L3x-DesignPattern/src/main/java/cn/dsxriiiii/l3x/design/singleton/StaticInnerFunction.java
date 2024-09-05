package cn.dsxriiiii.l3x.design.singleton;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.SingletonPattern
 * @Date 2024/8/21 14:15
 * @Description: 静态内部类实现单例模式
 * JVM 保证静态字段的初始化是线程安全的
 */
public class StaticInnerFunction {
    private StaticInnerFunction(){}
    private static StaticInnerFunction getInstance(){
        return StaticInner.INSTANCE;
    }
    private static class StaticInner{
        private final static StaticInnerFunction INSTANCE = new StaticInnerFunction();
    }
}
