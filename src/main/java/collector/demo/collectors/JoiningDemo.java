package collector.demo.collectors;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collectors工具API的使用
 * ************************************************************************
 * joining()                                                              *
 * joining(CharSequence delimiter)                                        *
 * joining(CharSequence delimiter,CharSequence prefix,CharSequence suffix)*
 * ************************************************************************
 * 为社么使用stream流而不是使用for循环拼接字符？
 * 流使用简洁，代码较少
 * 流如何在多线程环境下使用？
 * 1.使用parallelStream代替Stream2.每个线程创建一个stream
 * @author Slet
 * 11/12 2019
 */
public class JoiningDemo {

    public static void main(String[] args) {
        String[] arr={"按","时","吃","饭"};
        Stream<String> stream = Arrays.asList(arr).parallelStream();
        String r1 = stream.collect(joining());
        System.out.println(r1);
        new Thread(() -> {
            /**需要创建流，不能使用相同的流*/
            Stream<String> stream2 = Arrays.asList(arr).parallelStream();
            System.out.println(stream2.collect(joining_m1()));
        }).start();
        new Thread(() -> {
            /**需要创建流，不能使用相同的流*/
            Stream<String> stream3 = Arrays.asList(arr).parallelStream();
            System.out.println(stream3.parallel().collect(joining_m3()));
        }).start();
    }

    /**
     * 拼接字符
     * @return
     */
    public static Collector<CharSequence,?,String> joining(){
        return Collectors.joining();
    }

    /**
     * 拼接字符+分隔符
     * @return
     */
    public static Collector<CharSequence,?,String> joining_m1(){
        return Collectors.joining(",");
    }

    /**
     * 拼接字符+分隔符+前后缀
     * @return
     */
    public static Collector<CharSequence,?,String> joining_m3(){
        return Collectors.joining(",","{","}");
    }
}
