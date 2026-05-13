package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
            UserService userService = new UserServiceImpl();

            userService.createUsersTable();

            userService.saveUser("Александр", "Иванов", (byte) 25);
            userService.saveUser("Мария", "Степанова", (byte) 27);
            userService.saveUser("Игорь", "Васильев", (byte) 36);
            userService.saveUser("Евдокия", "Григорьева", (byte) 30);

            userService.getAllUsers().forEach(System.out::println);

            userService.cleanUsersTable();
            userService.dropUsersTable();
    }
}
