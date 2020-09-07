package collector.util;

import pojo.Student;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SletZh
 * @Date 2020-09-07-22:11
 */
public class CollectorConstant {

    public static final List<User> USERS=new ArrayList<>();
    public static final List<Student> STUDENTS=new ArrayList<>();

    static {
        initUsers();
        initStudents();
    }

    private static void initStudents() {
        STUDENTS.add(new Student().setName("tony").setScore(82.0).setClassName("六年级1班").setGender("男"));
        STUDENTS.add(new Student().setName("john").setScore(76.0).setClassName("六年级1班").setGender("男"));
        STUDENTS.add(new Student().setName("lucy").setScore(92.0).setClassName("六年级1班").setGender("女"));
        STUDENTS.add(new Student().setName("rose").setScore(68.0).setClassName("六年级1班").setGender("女"));
        STUDENTS.add(new Student().setName("alice").setScore(73.0).setClassName("六年级1班").setGender("女"));
        STUDENTS.add(new Student().setName("bob").setScore(53.0).setClassName("六年级2班").setGender("男"));
        STUDENTS.add(new Student().setName("jack").setScore(99.0).setClassName("六年级2班").setGender("男"));
        STUDENTS.add(new Student().setName("rock").setScore(61.0).setClassName("六年级2班").setGender("男"));
        STUDENTS.add(new Student().setName("anna").setScore(89.0).setClassName("六年级2班").setGender("女"));
        STUDENTS.add(new Student().setName("cathy").setScore(98.0).setClassName("六年级2班").setGender("女"));
    }

    private static void initUsers() {
        USERS.add(new User().setAge(20).setDeptName("教育一部").setSalary(4800.0).setName("Tony"));
        USERS.add(new User().setAge(21).setDeptName("教育一部").setSalary(3600.0).setName("Bob"));
        USERS.add(new User().setAge(23).setDeptName("教育一部").setSalary(6300.0).setName("lucy"));
        USERS.add(new User().setAge(28).setDeptName("总务部").setSalary(12_000.0).setName("john"));
        USERS.add(new User().setAge(27).setDeptName("教育二部").setSalary(8800.0).setName("jack"));
        USERS.add(new User().setAge(25).setDeptName("教育二部").setSalary(5500.0).setName("rose"));
        USERS.add(new User().setAge(24).setDeptName("教育二部").setSalary(8200.0).setName("anna"));
        USERS.add(new User().setAge(18).setDeptName("教育二部").setSalary(2800.0).setName("cathy"));
        USERS.add(new User().setAge(18).setDeptName("教育二部").setSalary(2900.0).setName("rock"));
        USERS.add(new User().setAge(18).setDeptName("教育二部").setSalary(3100.0).setName("bob"));
    }
}
