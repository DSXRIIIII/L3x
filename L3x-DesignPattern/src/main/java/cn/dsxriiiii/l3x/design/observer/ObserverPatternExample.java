package cn.dsxriiiii.l3x.design.observer;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.observer
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 16:53
 * @Description: ObserverPatternExample
 **/
public class ObserverPatternExample {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver(subject);
        ConcreteObserver observer2 = new ConcreteObserver(subject);

        subject.setState(10);
        subject.setState(20);
        subject.removeObserver(observer1);
        subject.setState(30);
    }
}