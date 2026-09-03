import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class UserQueryService {

    public static List<User> findActiveAdults(List<User> users) {
        List<User> result = new ArrayList<>();
        result = users.stream()
                .filter(user -> user.getAge() >= 18 && "Active".equals(user.getStatus()) )
                .collect(Collectors.toUnmodifiableList());
        return result;
    }

    public static List<User> sortUsers(List<User> users) {
        List<User> result = new ArrayList<>();
        result = users.stream()
                .sorted(
                        Comparator.comparing(User::getAge)
                                .thenComparing(User::getUsername,Comparator
                                        .nullsLast(Comparator.naturalOrder()))
                ).collect(Collectors.toUnmodifiableList());
        return result;
    }

    public static List<UserVO> getActiveAdultsVO(List<User> users){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<UserVO> result = new ArrayList<>();
        result = users.stream()
                .filter(user -> "Active".equals(user.getStatus()) && user.getAge() >= 18)
                .sorted(
                Comparator.comparing(User::getAge)
                        .thenComparing(
                                User::getUsername,
                                Comparator.nullsLast(
                                        Comparator.naturalOrder()
                                )
                        )
        )
                .map(user -> new UserVO(user.getId(),
                                           user.getUsername(),
                                            user.getCreatedAt() == null
                                                    ? "暂无创建时间"
                                                    : user.getCreatedAt().format(formatter)))
                .collect(Collectors.toUnmodifiableList());

        return  result;
    }
    public static long countActiveUsers(List<User> users){
        long result = 0;
        result = users.stream()
                .filter(user -> "Active".equals(user.getStatus()))
                .count();
        return result;
    }
    public static boolean hasMinorUser(List<User> users){
        boolean result;
        result = users.stream()
                .anyMatch(
                        user -> user.getAge() < 18
                );
        return result;
    }
    public static Optional<User> findFirstInactiveUser(List<User> users){
        return users.stream()
                .filter(user -> "INActive".equals(user.getStatus()))
                .findFirst();
    }

    public static List<UserVO> queryUsers(List<User> users){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<UserVO> result = new ArrayList<>();
        result = users.stream()
                .filter(user -> "Active".equals(user.getStatus())
                && user.getAge() >= 18)
                .sorted(Comparator.comparing(User::getAge)
                        .thenComparing(User::getUsername
                        , Comparator.nullsLast(Comparator.naturalOrder()))
                )
                .map(user -> new UserVO(
                        user.getId(),
                        user.getUsername(),
                        user.getCreatedAt() == null
                                ? "暂无创建时间"
                                : user.getCreatedAt().format(formatter))
                ).collect(Collectors.toList());
        return result;
    }
}
