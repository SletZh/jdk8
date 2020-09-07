package 设计模式.单例.demo;

/**
 * @author SletZh
 * @Date 2020-03-22-23:34
 */
public class LazyMan {
    private static volatile LazyMan lazyMan;

    private LazyMan(){}

    public static LazyMan getInstance(){
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null){
                    lazyMan=new LazyMan();
                }
            }
        }
        return lazyMan;
    }
}
