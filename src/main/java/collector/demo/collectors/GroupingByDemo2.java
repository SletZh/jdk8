package collector.demo.collectors;

import collector.util.CollectorConstant;
import collector.util.StudentScoreCollector;
import pojo.Student;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Collectors工具API的使用
 * ****************************************
 * group by(Function(),Collector<T,A,R>)  *
 * ****************************************
 * @author Slet
 * 11/12 2019
 */
public class GroupingByDemo2 {
    public static void main(String[] args) {

        /**使用collect进行遍历，对user两次分组，先按照年纪分组，再按照性别分组*/
        Map<String, Map<String, List<Student>>> collect = CollectorConstant.STUDENTS.stream().collect(groupByCollector_Combiner());
        System.out.println(collect);
        /**使用collect进行遍历，对user进行按年级分组，筛选出分数大于80分的学生*/
        Map<String, List<Student>> collect1 =  CollectorConstant.STUDENTS.stream().collect(groupByCollector_Combiner_m2());
        System.out.println(collect1);
        /**分组并求最大值*/
        Comparator<Student> comparator=(o1, o2) -> (int) (o1.getScore()-o2.getScore());
        Map<String, Optional<Student>> collect2 =  CollectorConstant.STUDENTS.stream().collect(Collectors.groupingBy(Student::getClassName, Collectors.maxBy(comparator)));
        System.out.println(collect2);
    }

    /**
     * groupingBy(分组条件，归约收集器)
     * 归约收集器：对分组结果再次进行收集，与andThen类似。
     * 对user两次分组，先按照年纪分组，再按照性别分组
     * @return*/
    public static Collector<Student, ?, Map<String, Map<String, List<Student>>>> groupByCollector_Combiner(){
        Collector<Student, ?, Map<String, List<Student>>> collector=Collectors.groupingBy(Student::getGender);
        return Collectors.groupingBy(Student::getClassName,collector);
    }

    /**
     * groupingBy(分组条件，自定义收集器)
     * 其中自定义收集器不能使用Collector.of()方法，该方法具有局限性
     * 自定义收集器：T:Student,R:List<Student>,实现对分数的筛选，取大于80分的学生
     * 两次收集结果的组合由API使用。
     * @return
     */
    public static Collector<Student,?,Map<String,List<Student>>> groupByCollector_Combiner_m2(){
        return Collectors.groupingBy(Student::getClassName,new StudentScoreCollector());
    }
}
