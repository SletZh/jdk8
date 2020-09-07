package collector.util;

import pojo.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/***
 * Collectors工具API的使用
 * 自定义收集器
 * 实现对分数的筛选
 * 支持多线程并发
 * @author Slet
 * 11/12 2019
 */
public class StudentScoreCollector implements Collector<Student, List<Student>,List<Student>>{
    @Override
    public Supplier<List<Student>> supplier() {
        return () -> new ArrayList<>(10);
    }

    @Override
    public BiConsumer<List<Student>, Student> accumulator() {
        return (students, student) -> {
            if(student.getScore()>=80)
                students.add(student);
        };
    }
    @Override
    public BinaryOperator<List<Student>> combiner() {
        return (students, students2) -> {
            students.addAll(students2);
            return students;
        };
    }
    @Override
    public Function<List<Student>, List<Student>> finisher() {
        return students -> students;
    }

    @Override
    public Set<Collector.Characteristics> characteristics() {
        Set<Collector.Characteristics> set=new HashSet<>();
        set.add(Characteristics.IDENTITY_FINISH);
        return set;
    }
}
