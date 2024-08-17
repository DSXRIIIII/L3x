package cn.dsxriiiii.l3x.zookeeper;

/**
 * @ProjectName: L3x-Zookeeper
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/22 16:08
 * @Email: lihh53453@hundsun.com
 */
public class Main {
    public static void main(String[] args) {
        Ticket12306 ticket12306 = new Ticket12306();

        //创建客户端
        Thread t1 = new Thread(ticket12306,"携程");
        Thread t2 = new Thread(ticket12306,"飞猪");

        t1.start();
        t2.start();
    }
}
