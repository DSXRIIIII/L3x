package cn.dsxriiiii.l3x.design.command;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.command
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:08
 * @Description: 命令模式
 **/
public class CommandPatternExample {
    public static void main(String[] args) {
        Light light = new Light();
        Command onCommand = new LightOnCommand(light);
        Command offCommand = new LightOffCommand(light);
        RemoteControl remote = new RemoteControl();
        remote.setCommand(onCommand);
        remote.pressButton();
        remote.setCommand(offCommand);
        remote.pressButton();
    }
}
