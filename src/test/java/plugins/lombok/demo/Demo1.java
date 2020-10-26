package plugins.lombok.demo;

import plugins.lombok.pojo.Po1;
import plugins.lombok.pojo.Po2;

/**
 * @author SletZh
 * @Date 2020-09-15-17:36
 */

public class Demo1 {
    public static void main(String[] args) {
        buildTest();
        accessorsTest();
    }

    public static void buildTest(){
        Po1 po1= Po1.builder().var1("var1").var2("var2").var3("var3").build();
        System.out.println(po1);
    }

    public static void accessorsTest(){
        Po2 po2= new Po2();
        po2.setVar1("var1");
        po2.setVar2("var2");
        po2.setVar3("var3");
        System.out.println(po2);
    }
}
