package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:postgresql://localhost:5432/1_1_3_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "383838";

    private static SessionFactory sessionFactory;

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

    // SessionFactory Hibernate
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Настройки Hibernate без hibernate.cfg.xml
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, URL);
                settings.put(Environment.USER, USERNAME);
                settings.put(Environment.PASS, PASSWORD);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

                // SQL-запросы в консоли
                settings.put(Environment.SHOW_SQL, "true");

                // Управление контекстом сессий (чтобы сессия привязывалась к текущему потоку)
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                configuration.setProperties(settings);

                // Регистрация класса User
                configuration.addAnnotatedClass(User.class);

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Ошибка при создании SessionFactory!");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
