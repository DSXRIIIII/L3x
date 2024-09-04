package cn.dsxriiiii.l3x.design.chain.factory;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.chain.factory
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 17:24
 * @Description: AbstractActionChain
 **/
public abstract class AbstractActionChain implements Handler{

    private Handler next;

    @Override
    public Handler next() {
        return next;
    }

    @Override
    public Handler appendNext(Handler next) {
        this.next = next;
        return next;
    }
}
