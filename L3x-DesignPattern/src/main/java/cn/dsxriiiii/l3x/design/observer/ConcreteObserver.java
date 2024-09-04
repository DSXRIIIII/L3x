package cn.dsxriiiii.l3x.design.observer;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.observer
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 16:47
 * @Description: ConcreteObserver
 **/
public class ConcreteObserver implements Observer {
    private int observerState;
    private final ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() {
        observerState = subject.getState();
        System.out.println("Observer state updated to: " + observerState);
    }
}
