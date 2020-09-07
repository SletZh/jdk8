package collector.demo.collectors;

import collector.util.CollectorConstant;
import pojo.Student;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Collectors工具API的使用
 * ************************************************************************
 * reducing(binaryOperate)                                               *
 * reducing(id,binaryOperate)                                            *
 * reducing(id,function,binaryOperate)                                   *
 * ************************************************************************
 * @author Slet
 * 11/13 2019
 */
public class ReducingDemo {

    public static void main(String[] args) {
        /**
         * 收集最高分数的学生,按年级分组
         * @see GroupingByDemo2
         * */
        Map<String, Optional<Student>> collect = CollectorConstant.STUDENTS.stream().collect(Collectors.groupingBy(Student::getClassName,reducing()));
        System.out.println(collect);
        /**
         * 收集最高分数的学生并加入初始值,按年级分组
         * @see GroupingByDemo2
         * */
        Map<String, Student> collect2 = CollectorConstant.STUDENTS.stream().collect(Collectors.groupingBy(Student::getClassName,reducing_m2()));
        System.out.println(collect2);
    }
    /***
     * reducing(binaryOperate)
     * @return 对输入数据进行减少
     * @apiNote BinaryOperator:比较器，比较分数
     */
    public static Collector<Student,?, Optional<Student>> reducing(){
        return Collectors.reducing(BinaryOperator.maxBy((o1, o2) -> (int)(o1.getScore()-o2.getScore())));
    }
    /***
     * reducing(id,binaryOperate)
     * @return 对输入数据进行减少
     * @apiNote student:加入的初始数据，BinaryOperator:比较器，比较分数
     */
    public static Collector<Student,?, Student> reducing_m2(){
        Student student=new Student().setName("rose").setScore(100.0).setClassName("六年级1班").setGender("女");
        return Collectors.reducing(student,BinaryOperator.maxBy((o1, o2) -> (int)(o1.getScore()-o2.getScore())));
    }
    /***
     * reducing(id,function,binaryOperate)
     * @return 对输入数据进行减少
     * @apiNote student:加入的初始数据，BinaryOperator:比较器，比较分数
     */
    public static Collector<Student,?, Student> reducing_m3(){
        Student student=new Student().setName("rose").setScore(100.0).setClassName("六年级1班").setGender("女");
        // TODO: 2019/11/13 书写function
        return Collectors.reducing(student,student1 -> student1,BinaryOperator.maxBy((o1, o2) -> (int)(o1.getScore()-o2.getScore())));
    }
}
