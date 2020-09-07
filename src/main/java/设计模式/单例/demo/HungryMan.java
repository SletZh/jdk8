package 设计模式.单例.demo;

/**
 * @author SletZh
 * @Date 2020-03-22-23:31
 */
public class HungryMan {

    private HungryMan(){}

    public static HungryMan getInstance(){
        return Inner.HUNGRY_MAN;
    }

    private static class Inner{
        private static final HungryMan HUNGRY_MAN =new HungryMan();
    }
}
