import java.util.ArrayList;
import java.util.List;

/**
 * @author Zafarzhon Odilov
 * @link <a href="https://github.com/zafarzhon">github.com/zafarzhon</a>
 */
public class Main {
    public static void main(String[] args) {
        //Creating Students
        List<Student> students = createStudents();

        System.out.println("print all students\n");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nprint all students who age greater than 20\n");
        for (Student student : getStudetnsAgeGreater20(students)) {
            System.out.println(student);
        }

        System.out.println("\nprint all students who visit less than 2 " +
                "classes\n");
        for (Student student : getStudetnsVisitClassesLess2(students)) {
            System.out.println(student);
        }

        System.out.println("\nprint all students who visit class " +
                "programming\n");
        for (Student student : getStudentVisitsProgramming(students)) {
            System.out.println(student);
        }


    }


    private static List<Student> getStudetnsAgeGreater20(List<Student> students) {
        List<Student> studentsAgeGreater20 = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() > 20) {
                studentsAgeGreater20.add(student);
            }
        }
        return studentsAgeGreater20;
    }

    private static List<Student> getStudetnsVisitClassesLess2(List<Student> students) {
        List<Student> studentsLess2 = new ArrayList<>();
        for (Student student : students) {
            if (student.getClasses().size() < 2) {
                studentsLess2.add(student);
            }
        }
        return studentsLess2;
    }

    private static List<Student> getStudentVisitsProgramming(List<Student> students) {
        List<Student> studentsVisitProgramming = new ArrayList<>();
        for (Student student : students) {
            if (student.getClasses().contains("programming")) {
                studentsVisitProgramming.add(student);
            }
        }
        return studentsVisitProgramming;
    }

    private static List<Student> createStudents() {
        return new ArrayList<>(List.of(
                new Student("Emmalynn", "Female", 18, List.of("Math", "physics", "russian", "english", "history", "music",
                        "programming", "gymnastics")),
                new Student("Lenee", "Female", 28, List.of("russian", "english", "history", "music", "gymnastics")),
                new Student("Vivi", "Female", 24, List.of("Math", "physics", "russian", "english",
                        "programming", "gymnastics")),
                new Student("Roman", "Male", 22, List.of("Math", "physics", "russian", "english",
                        "programming", "gymnastics")),
                new Student("Aksel", "Male", 19, List.of("russian", "english", "history", "gymnastics")),
                new Student("Arline", "Female", 19, List.of("Math", "history", "music",
                        "programming", "gymnastics")
                ),
                new Student("Pam", "Bigender", 28, List.of("Math", "russian", "english", "history",
                        "programming")),
                new Student("Abner", "Male", 23, List.of("Math", "physics", "russian", "english",
                        "programming", "gymnastics")),
                new Student("Lethia", "Female", 27, List.of("english")),
                new Student("Tommy", "Male", 22, List.of("Math", "russian", "english", "history",
                        "programming")),
                new Student("Rockey", "Male", 25, List.of("russian", "english", "history", "music", "gymnastics")),
                new Student("Aylmar", "Male", 20, List.of("Math", "history", "music",
                        "programming", "gymnastics")
                ),
                new Student("Alick", "Male", 22, List.of("gymnastics")),
                new Student("Rica", "Female", 18, List.of("Math", "physics", "russian", "english", "history", "music",
                        "programming", "gymnastics")),
                new Student("Jacqui", "Female", 15, List.of("russian", "english", "history", "music", "gymnastics")),
                new Student("Early", "Male", 25, List.of("Math", "physics",
                        "russian", "english", "history", "music",
                        "programming", "gymnastics")),
                new Student("Ulrikaumeko", "Female", 15, List.of("Math", "russian", "english", "history",
                        "programming")),
                new Student("Selia", "Female", 15, List.of("russian", "english", "history", "music", "gymnastics")),
                new Student("Avram", "Male", 30, List.of("Math", "physics", "russian", "english", "history", "music",
                        "programming", "gymnastics")),
                new Student("Percival", "Male", 29, List.of("Math", "russian", "english", "history",
                        "programming")),
                new Student("Orelie", "Female", 29, List.of("russian", "english", "history", "music", "gymnastics")),
                new Student("Davidde", "Male", 14, List.of("russian", "english", "history", "gymnastics")),
                new Student("Rivi", "Female", 20, List.of("Math", "physics",
                        "russian", "english",
                        "programming", "gymnastics"))
        ));
    }

}
