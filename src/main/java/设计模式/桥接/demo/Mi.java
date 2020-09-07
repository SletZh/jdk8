package 设计模式.桥接.demo;

/**
 * @author SletZh
 * @Date 2020-03-24-20:58
 */
public class Mi extends Phone {
    public Mi(Memory memory) {
        super(memory);
    }

    @Override
    void buy() {
        System.out.println("购买了小米手机");
        super.buy();
    }


}
