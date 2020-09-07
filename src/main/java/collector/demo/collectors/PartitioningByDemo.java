package collector.demo.collectors;

import collector.util.CollectorConstant;
import collector.util.StudentGenderCollector;
import pojo.Gender;
import pojo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Collectors工具API的使用
 * ************************************************************************
 *  partitioningBy(predicate)                                             *
 *  partitioningBy(predicate,collector)                                   *
 * ************************************************************************
 * @author Slet
 * 11/13 2019
 */
public class PartitioningByDemo {

    public static void main(String[] args) {
        /**对学生分区，大于80分，小于等于80分*/
        Map<Boolean, List<Student>> collect = CollectorConstant.STUDENTS.stream().collect(partitioningBy());
        System.out.println(collect);
        /**对学生分区，大于80分，小于等于80分,筛选出男生*/
        Map<Boolean, List<Student>> collect1 =  CollectorConstant.STUDENTS.stream().collect(partitioningBy_m2());

        System.out.println(collect1);
    }
    /***
     * @return 对输入数据进行分区
     * @apiNote Predicate<Student>:分区条件
     */
    public static Collector<Student,?, Map<Boolean,List<Student>>> partitioningBy(){
        return Collectors.partitioningBy(student -> student.getScore()>80);
    }
    /***
     * @return 对输入数据进行分区
     * @apiNote Predicate<Student>:分区条件,collector:自定义收集器，收集指定性别的数据
     * @see StudentGenderCollector
     */
    public  static  Collector<Student,?, Map<Boolean,List<Student>>> partitioningBy_m2(){
        return Collectors.partitioningBy(student -> student.getScore()>80,new StudentGenderCollector(Gender.MAN));
    }
}
