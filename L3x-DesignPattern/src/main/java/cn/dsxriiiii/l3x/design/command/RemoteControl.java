package cn.dsxriiiii.l3x.design.command;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.command
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:07
 * @Description: RemoteControl
 **/
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command!= null) {
            command.execute();
        }
    }
}
