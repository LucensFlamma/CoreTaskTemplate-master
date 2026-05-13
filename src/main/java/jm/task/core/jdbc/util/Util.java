package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:postgresql://localhost:5432/1_1_3_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "my password";

    public static Connection getConnection() {
        Connection connection = null;
        try  {
            return connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка соединения с БД!");
        }
        return connection;
    }

}
