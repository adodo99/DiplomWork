package DiplomProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    static List<User> userList=new ArrayList<>();
    private int age;
    private String firstName;
    private String secondName;
    private boolean invalid;


    public User(int age, String firstName, String secondName, boolean invalid) {
        this.age = age;
        this.firstName = firstName;
        this.secondName = secondName;
        this.invalid = invalid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && invalid == user.invalid && firstName.equals(user.firstName) && secondName.equals(user.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, firstName, secondName, invalid);
    }

    @Override
    public String toString() {
        return "Пользователь:" + firstName+" " +secondName +" ,"+
                "возраст=" + age +
                ", VIP=" + invalid +
                ";\n";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }
}
