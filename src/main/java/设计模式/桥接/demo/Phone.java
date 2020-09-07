package 设计模式.桥接.demo;



/**
 * @author SletZh
 * @Date 2020-03-24-20:45
 */
public abstract class Phone {
    protected Memory memory;

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Phone(Memory memory){
        this.memory = memory;
    }
    void buy(){
        memory.add();
    };
}
