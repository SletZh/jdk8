package collector.demo.collectors;

import collector.demo.collectors.AndThenDemo;
import collector.util.CollectorConstant;
import pojo.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Collectors工具API的使用
 * ************************************************************************
 * mapping(function,collector)                                                             *
 * ************************************************************************
 * @author Slet
 * 11/12 2019
 */
public class MappingDemo {

    public static void main(String[] args) {
        /**
         * 经过过滤，筛选薪资大于3000的员工,获取所有员工的薪水
         * 使用收集器，收集员工的薪水，并排序
         * 打印输出结果
         * @see AndThenDemo
         *
         */
        List<Double> collect = CollectorConstant.USERS.stream().filter(user -> user.getSalary()>3000).collect(collectorMapping());
        System.out.println(collect);
    }

    public static  Collector<User,?,List<Double>> collectorMapping(){
        /**
         * mapping(function,collector)
         * function:获取用户的薪水
         * collector:完成转为list集合和排序的功能
         */
        return Collectors.mapping(User::getSalary,Collectors.collectingAndThen(Collectors.toList(),doubles -> {
            Collections.sort(doubles);
            return doubles;
        }));
    }
}
