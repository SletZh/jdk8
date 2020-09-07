package 设计模式.代理.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author SletZh
 * @Date 2020-03-22-19:07
 */
public class DynamicProfxy implements InvocationHandler {
    private  Object object;//接口的任意一种实现类即可
    public DynamicProfxy(Object object){
        this.object=object;
    }

    /**
     *
     * @param proxy 代理类
     * @param method 代理方法
     * @param args  方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("买车前准备");
        Object object=method.invoke(this.object,args); //执行被代理方法
        System.out.println("买车后驾车");
        return object;
    }
}
