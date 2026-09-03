import java.util.*;

public class Day11Demo {

    public static List<User> sortUsers(List<User> users) {
        List<User> result = new ArrayList<>(users);
        result.sort(
                Comparator.comparing(User::getAge)
                        .thenComparing(User::getUsername,
                                Comparator.nullsLast(Comparator.naturalOrder()))
        );
        return  result;
    }

    public static void main(String[] args) {
            User u1 = new User(1L, "Tommy",22,"Active");
            User u2 = new User(2L, "Jerry",22,"Active");
            User u3 = new User(3L, "Alice",18,"INActive");
            User u4 = new User(4L, "Jack",18,"Active");
            User u5 = new User(5L, "Bob",25,"Active");
            User u6 = new User(6L, null,20,"Active");
        User u7 = new User(7L, null,29,"Active");
        List<User> users = new ArrayList();
        users.add(u1);
        users.add(u2);users.add(u3);users.add(u4);users.add(u5);users.add(u6);users.add(u7);

        List<Integer> nubmers = new ArrayList<>();
        nubmers.add(8);
        nubmers.add(3);
        nubmers.add(9);
        nubmers.add(1);
        nubmers.add(5);
        Collections.sort(nubmers);
        System.out.println(nubmers);
        users.sort(
                Comparator.comparing(User::getAge)
        );
        System.out.println("task1"+ users);
        users.sort(
                Comparator.comparing(User::getAge).reversed()
        );
        System.out.println("task2"+ users);
        //task4
        List<User> original = new ArrayList<>(users);
        List<User> copy = new ArrayList<>(original);
        original.clear();
        System.out.println("task4"+ copy);

        List<User> original2 = new ArrayList<>(users);
        List<User> copy2 = new ArrayList<>(original2);

        copy2.get(0).setUsername("CHANGED");

        System.out.println(
                original2.get(0).getUsername()
        );
        copy2.get(0).setUsername("CHANGED");
        System.out.println("task4"+ original.get(0).getUsername());

        //task5
        try{
            List<String> status =
                    List.of("ACTIVE", "INACTIVE");
            status.add("DELETED");
        }catch (UnsupportedOperationException e)
        {
            System.out.println("List.of不可被修改");
        }
        List<String> original1 =
                new ArrayList<>();

        original1.add("ACTIVE");

        List<String> readonly =
                Collections.unmodifiableList(original1);

        original1.add("INACTIVE");
        System.out.println("task5"+ readonly);
        try {
            readonly.add("DELETED");
        } catch (UnsupportedOperationException e) {
            System.out.println("readonly不能直接修改");
        }

    }
}
