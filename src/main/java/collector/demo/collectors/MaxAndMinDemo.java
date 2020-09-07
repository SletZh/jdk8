package collector.demo.collectors;

import collector.util.CollectorConstant;
import pojo.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Collectors工具API的使用
 * ************************************************************************
 * maxBy(comparator)    stream.max(comparator)代替                        *
 * minBy(comparator)    stream.min(comparator)代替                        *
 * ************************************************************************
 * @author Slet
 * 11/12 2019
 */
public class MaxAndMinDemo {

    public static void main(String[] args) {
        /**
         *自定义比较器,比较薪水
         * 比较器的结果为最高或最低薪水的用户
         */
        Comparator<User> comparator=(o1, o2) -> {
            return (int) (o1.getSalary()-o2.getSalary());
        };
        Optional<User> maxSalary = CollectorConstant.USERS.stream().max(comparator);
        System.out.println(maxSalary);
        Optional<User> minSalary = CollectorConstant.USERS.stream().min(comparator);
        System.out.println(minSalary);
    }

}
