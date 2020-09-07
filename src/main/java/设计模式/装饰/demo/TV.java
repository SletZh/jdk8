package 设计模式.装饰.demo;

/**
 * @author SletZh
 * @Date 2020-03-24-22:03
 */
public class TV extends Decorator {
    public TV(House house) {
        super(house);
    }

    @Override
    public void live() {
        house.live();
        System.out.println("添加了电视");
    }
}
