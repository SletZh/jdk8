package collector.demo.collectors;

import collector.util.CollectorConstant;
import pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Collectors工具API的使用
 *
 * @author Slet
 * 11/12 2019
 */
public class CountingDemo {
    public static void main(String[] args) {
        Long count = CollectorConstant.USERS.stream().collect(Collectors.counting());
        System.out.println(count);
    }
}
