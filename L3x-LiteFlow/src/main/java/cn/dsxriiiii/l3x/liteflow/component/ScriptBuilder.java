package cn.dsxriiiii.l3x.liteflow.component;

import com.yomahub.liteflow.script.ScriptExecuteWrap;
import com.yomahub.liteflow.script.body.JaninoCommonScriptBody;

/**
 * @ProjectName: L3x-LiteFlow
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/14 13:41
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
public class ScriptBuilder implements JaninoCommonScriptBody{
    @Override
    public Void body(ScriptExecuteWrap scriptExecuteWrap) {
        System.out.println("123");
        return null;
    }
}
