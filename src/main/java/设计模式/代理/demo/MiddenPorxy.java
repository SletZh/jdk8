package 设计模式.代理.demo;

/**
 * @author SletZh
 * @Date 2020-03-22-18:53
 */
public class MiddenPorxy implements  CarShop, HouseShop {
    private BuyCar buyCar;
    private BuyHouse buyHouse;

    public MiddenPorxy(BuyCar buyCar){
        this.buyCar=buyCar;
    }
    public MiddenPorxy(BuyHouse buyHouse){
        this.buyHouse=buyHouse;
    }
    @Override
    public void buyCar() {
        System.out.println("买车前准备");
        buyCar.buyCar();
        System.out.println("买车后架车");
    }

    @Override
    public void buyHouse() {
        System.out.println("买房前准备");
        buyHouse.buyHouse();
        System.out.println("买房后居住");
    }
}
