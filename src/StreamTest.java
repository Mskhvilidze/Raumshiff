import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Sam", "Mika", "Thomas", "Benny", "Aaron", "Annabelle", "Sven", "Cece", "Diesel");

        List<User> users = list.stream().filter(StreamTest::isNotSam).map(user -> new User(user, (int) (Math.random() * 30 - 20) + 20))
                .sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());

        for (User user : users) {
            System.out.println(user.toString());
        }


    }

    private static boolean isNotSam(String name) {
        return !name.equals("Sam");
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Name: " + this.name + "\n" + "Age" + this.age;
    }
}