package 设计模式.桥接.demo;

/**
 * @author SletZh
 * @Date 2020-03-24-20:56
 */
public class Memory4G implements Memory {
    @Override
    public void add() {
        System.out.println("加上了4g内存");
    }
}
