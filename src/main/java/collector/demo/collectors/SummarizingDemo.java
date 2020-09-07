package collector.demo.collectors;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Collectors工具API的使用
 * 汇总+求和
 * ************************************************************************
 * summarizingInt,summarizingLong,summarizingDouble                       *
 * summingInt, summingLong,summingDouble:使用mapToInt....                 *
 * ************************************************************************
 * @author Slet
 * 11/13 2019
 */
public class SummarizingDemo {

    public static void main(String[] args) {
       //随机数组
        ArrayList<Integer> list=new ArrayList<>(10);
        for (int i = 0; i <10; i++) {
            list.add(new Random().nextInt(100));
        }
        System.out.println(list);
        //对数组汇总，和，计数，最大值，最小值，均值
        DoubleSummaryStatistics collect = list.stream().collect(Collectors.summarizingDouble(Integer::doubleValue));
        System.out.println(collect);
        //求和
        //Double sum = list.stream().collect(Collectors.summingDouble(Integer::doubleValue));
        double sum = list.stream().mapToDouble(Integer::doubleValue).sum();
        System.out.println(sum);
    }
}
