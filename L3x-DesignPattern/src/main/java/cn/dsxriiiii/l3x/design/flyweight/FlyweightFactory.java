package cn.dsxriiiii.l3x.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.flyweight
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:45
 * @Description: 享元模式工厂
 **/
public class FlyweightFactory {
    private final Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
}
