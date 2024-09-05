package cn.dsxriiiii.l3x.design.facade.example;

import cn.dsxriiiii.l3x.design.facade.Facade;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.facade.example
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:34
 * @Description: 外观模式
 * 外观模式为复杂的子系统提供一个简单统一的接口，与其他设计模式相比，它主要侧重于简化系统的外部调用方式，减少客户端与子系统的耦合
 * 一个电源总开关可以控制四盏灯、一个风扇、一台空调和一台电视机的启动和关闭。通过该电源总开关可以同时控制上述所有电器设备
 * 外观模式是迪米特法则的一种具体实现
 **/
public class FacadePatternExample {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operation();
    }
}
