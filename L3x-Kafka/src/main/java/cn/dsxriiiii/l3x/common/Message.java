package cn.dsxriiiii.l3x.common;

/**
 * @PackageName: cn.dsxriiiii.l3x
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/25 16:56
 * @Description: message
 **/
public class Message {
    private String messageId;
    private String messageDescription;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        messageDescription = messageDescription;
    }

    public Message(String messageId,String messageDescription) {
        this.messageDescription = messageDescription;
        this.messageId = messageId;
    }
}
