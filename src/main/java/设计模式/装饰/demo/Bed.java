package 设计模式.装饰.demo;

/**
 * @author SletZh
 * @Date 2020-03-24-22:01
 */
public class Bed extends Decorator {
    public Bed(House house) {
        super(house);
    }

    @Override
    public void live() {
        house.live();
        System.out.println("添加了床");
    }
}
