package cn.dsxriiiii.l3x.design.command;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.command
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/05 10:07
 * @Description: LightOffCommand
 **/
public class LightOffCommand implements Command{
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
