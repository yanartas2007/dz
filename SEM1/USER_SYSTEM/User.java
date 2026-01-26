package SEM1.USER_SYSTEM;

public class User {
    private String username;
    private UserRole role;
    private int age;

    public User(String username, UserRole role, int age) {
        setUsername(username);
        setRole(role);
        setAge(age);
    }

    public void checkAge() {
        if (getAge() < 18) {
            throw new IllegalArgumentException();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
