package cn.dsxriiiii.l3x.liteflow.context;

import lombok.*;

import java.io.Serializable;

/**
 * @ProjectName: L3x-LiteFlow
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/14 11:22
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BusinessSceneContext implements Serializable{
    private static final long serialVersionUID = 9019583138655680839L;
    private String id;
}
