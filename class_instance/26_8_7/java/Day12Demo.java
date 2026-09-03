import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Day12Demo {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        User u1 = new User(1L, "Tommy",22,"Active");
        User u2 = new User(2L, "Jerry",22,"Active");
        User u3 = new User(3L, "Alice",18,"INActive");
        User u4 = new User(4L, "Jack",18,"Active");
        User u5 = new User(5L, "Bob",15,"Active");
        User u6 = new User(6L, null,20,"Active");
        User u7 = new User(7L, null,29,"Active");
        User u8 = new User(8L, "Damn",49,"INActive");
        List<User> users = new ArrayList<>();
        users.add(u8);
        users.add(u1);users.add(u2);users.add(u3);users.add(u4);users.add(u5);users.add(u6);users.add(u7);
        UserQueryService uqs = new UserQueryService();
        System.out.println("task1" + uqs.findActiveAdults(users));
        System.out.println("task2"+ uqs.sortUsers(users));
        System.out.println("task3"+ uqs.getActiveAdultsVO(users));
        System.out.println("task4"+ uqs.countActiveUsers(users));
        System.out.println("task5" + uqs.hasMinorUser(users));
        Optional<User> result = uqs.findFirstInactiveUser(users);
        result.ifPresent(user -> {
            System.out.println("找到第一个禁用用户：");
            System.out.println(user);
        });
        System.out.println("before:");
        System.out.println(users);

        List<UserVO> result1 =
                UserQueryService.queryUsers(users);

        System.out.println("result1:");
        System.out.println(result1);

        System.out.println("after:");
        System.out.println(users);


    }
}
