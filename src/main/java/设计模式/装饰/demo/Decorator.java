package 设计模式.装饰.demo;

/**
 * @author SletZh
 * @Date 2020-03-24-21:53
 */
public abstract class Decorator implements  House{
    protected House house;

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Decorator(House house){
        this.house=house;
    }


}
