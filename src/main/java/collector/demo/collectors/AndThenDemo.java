package collector.demo.collectors;

import collector.util.CollectorConstant;
import pojo.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Collectors工具API的使用
 *
 * @author Slet
 * 11/11 2019
 */
public class AndThenDemo {
    public static void main(String[] args) {
        List<Double> result = CollectorConstant.USERS.stream().filter(user -> user.getSalary() > 3000.0).map(User::getSalary)
                .collect( Collectors.collectingAndThen(
                Collectors.toList(), doubles -> {Collections.sort(doubles);return doubles;}
                 )
                );
        System.out.println(result);
    }
}
