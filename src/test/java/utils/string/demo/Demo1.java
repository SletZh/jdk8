package utils.string.demo;

import org.apache.commons.lang3.StringUtils;

/**
 * @author SletZh
 * @Date 2020-09-23-14:36
 */
public class Demo1 {
    public static void main(String[] args) {
        //非空校验
        String var1="";
        String var2=null;
        String var3=" ";
        System.out.println(StringUtils.isBlank(var1));
        System.out.println(StringUtils.isBlank(var2));
        System.out.println(StringUtils.isBlank(var3));
    }
}
