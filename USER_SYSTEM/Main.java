package USER_SYSTEM;

public class Main {
    public static void main(String[] args) {
        User u = new User("Олег", UserRole.USER, 20);
        User a = new User("Олегарх", UserRole.ADMIN, 10);
        User m = new User("Олежка", UserRole.MODERATOR, 25);

        Action anonim = new Action() {
            @Override
            public void execute(User user) {
                try {
                    user.checkAge();
                    if (user.getRole() == UserRole.MODERATOR) {
                        System.out.println("\"обычный пользователь\" ну или ваша фантазия");
                    } else if (user.getRole() == UserRole.ADMIN) {
                        System.out.println("\"имеет права администратора\" ну или ваша фантазия");
                    }
                }
                catch (IllegalArgumentException e) {
                    if (user.getRole() == UserRole.USER) {
                        throw new IllegalArgumentException();
                    }
                }
            }
        };

        anonim.execute(a);
        anonim.execute(m);
        anonim.execute(u);

    }
}
