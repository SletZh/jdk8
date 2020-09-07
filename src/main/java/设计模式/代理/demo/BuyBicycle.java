package 设计模式.代理.demo;

/**
 * @author SletZh
 * @Date 2020-03-22-23:06
 */
public class BuyBicycle  implements CarShop{
    @Override
    public void buyCar() {
        System.out.println("我要买自行车");
    }
}
