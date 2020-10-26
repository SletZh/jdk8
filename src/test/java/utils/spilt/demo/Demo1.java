package utils.spilt.demo;

import java.util.Arrays;

/**
 * @author SletZh
 * @Date 2020-09-28-10:19
 */
public class Demo1 {

    public static void main(String[] args) {
        String var1="调查省市：";
        String[] var2= var1.split(":");
        System.out.println(var2.length);
        System.out.println(var2[1]);
    }
}
