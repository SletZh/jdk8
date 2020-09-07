package collector.demo.collectors;

import collector.util.CollectorConstant;
import pojo.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Slet
 * 11/12 2019
 */
public class GroupingByDemo1 {
    public static void main(String[] args) {
        Map<String, List<User>> users = CollectorConstant.USERS.stream().collect(Collectors.groupingBy(User::getDeptName));
        System.out.println(users);
    }
}
