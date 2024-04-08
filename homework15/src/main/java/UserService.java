import java.util.*;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class UserService {
    static Set<User> users = Set.of(new User("Inger", 1, List.of("Prepare " +
                            "presentation slides",
                    "Organize files and documents",
                    "Collaborate with team on project")),
            new User("Marguerite", 2, List.of("Prepare presentation slides",
                    "Organize files and documents",
                    "Collaborate with team on project",
                    "Schedule team meeting",
                    "Brainstorm new ideas",
                    "Complete research report")),
            new User("Inger", 3, List.of("Organize files and documents",
                    "Collaborate with team on project",
                    "Schedule team meeting")),
            new User("Theressa", 4, List.of("Complete research report")),
            new User("Maggie", 5, List.of()));

    public static void main(String[] args) {
        System.out.println("printUsersTasksMore2");
        printUsersTasksMore2();
        System.out.println("printUsersExpMoreToLess");
        printUsersExpMoreToLess();
        System.out.println("printUniqNames");
        printUniqNames();


    }

    private static void printUsersTasksMore2() {
        for (User user : users) {
            if (user.getTasks() != null && user.getTasks().size() > 2) {
                System.out.println(user);
            }
        }
    }

    private static void printUsersExpMoreToLess() {
        Set<User> treeSet = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getExperience() - o1.getExperience();
            }
        });
        for (User user : users) {
            treeSet.add(user);
        }
        for (User user : treeSet) {
            System.out.println(user);
        }
    }

    private static void printUniqNames() {
        Set<String> userNames = new HashSet<>();
        for (User user : users) {
            userNames.add(user.getName());
        }
        for (String name : userNames) {
            System.out.println(name);
        }
    }
}
