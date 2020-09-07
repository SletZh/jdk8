package 设计模式.装饰.demo;

/**
 * @author SletZh
 * @Date 2020-03-24-21:58
 */
public class Person implements  House {
    @Override
    public void live() {
        System.out.println("住在房子里");
    }
}
