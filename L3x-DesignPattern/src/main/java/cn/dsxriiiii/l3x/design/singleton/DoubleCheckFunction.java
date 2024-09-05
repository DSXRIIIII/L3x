package cn.dsxriiiii.l3x.design.singleton;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.SingletonPattern
 * @Date 2024/8/21 14:24
 * @Description: 双重检查锁实现单例模式
 */
public class DoubleCheckFunction {
    private volatile static DoubleCheckFunction INSTANCE;
    private DoubleCheckFunction(){}
    private DoubleCheckFunction getInstance(){
        if(INSTANCE == null){
            synchronized (DoubleCheckFunction.class){
                if(INSTANCE == null){
                    INSTANCE = new DoubleCheckFunction();
                }
            }
        }
        return INSTANCE;
    }
}
