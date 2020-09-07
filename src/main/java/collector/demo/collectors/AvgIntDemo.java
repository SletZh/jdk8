package collector.demo.collectors;

import collector.util.CollectorConstant;
import pojo.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collectors工具API的使用
 *
 * @author Slet
 * 11/11 2019
 */
public class AvgIntDemo {

    public static void main(String[] args) {
        Double avg = CollectorConstant.USERS.stream().map(User::getSalary).collect(Collectors.toList()).stream().collect(
                Collectors.averagingDouble(Double::doubleValue)
        );
        System.out.println(avg);
    }
}
