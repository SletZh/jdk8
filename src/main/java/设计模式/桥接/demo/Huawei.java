package 设计模式.桥接.demo;

/**
 * @author SletZh
 * @Date 2020-03-24-20:48
 */
public class Huawei extends Phone{

    public Huawei(Memory memory) {
        super(memory);
    }

    @Override
    void buy() {
        System.out.println("购买了华为手机");
        super.buy();
    }


}
