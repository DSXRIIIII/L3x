package cn.dsxriiiii.l3x.design.observer;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.observer
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 16:45
 * @Description: 主题
 **/
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
