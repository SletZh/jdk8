package collector.demo.collectors;

import collector.util.CollectorConstant;
import collector.util.StudentScoreCollector;
import pojo.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Collectors工具API的使用
 * ***************************************************
 * group by(Function(),Supplier(),Collector<T,A,R>)  *
 * ***************************************************
 * 可变容器可以自定义使用的Map的任一实现类
 * @author Slet
 * 11/12 2019
 */
public class GroupingByDemo3 {
    public static void main(String[] args) {
        /**使用collect进行遍历，对user进行按年级分组，筛选出分数大于80分的学生*/
        Map<String, List<Student>> collect1 = CollectorConstant.STUDENTS.stream().collect(groupByCollector_Combiner_m2());
        System.out.println(collect1);
    }

    /**
     * groupingBy(分组条件，可变容器，自定义收集器)
     * 可变容器可以自定义使用的Map的任一实现类
     * 其中自定义收集器不能使用Collector.of()方法，该方法具有局限性
     * 自定义收集器：T:Student,R:List<Student>,实现对分数的筛选，取大于80分的学生
     * 两次收集结果的组合由API实现。
     * @return
     */
    public static Collector<Student,?,Map<String,List<Student>>> groupByCollector_Combiner_m2(){
        return Collectors.groupingBy(Student::getClassName, HashMap::new,new StudentScoreCollector());
    }
}
