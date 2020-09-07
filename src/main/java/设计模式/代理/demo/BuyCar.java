package 设计模式.代理.demo;

/**
 * @author SletZh
 * @Date 2020-03-22-18:48
 */
public class BuyCar implements CarShop{

    @Override
    public void buyCar() {
        System.out.println("我要买车");
    }
}
