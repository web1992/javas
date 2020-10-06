
package cn.web1992.utils.demo.classloader;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ExtClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        System.out.println(System.getProperty("java.ext.dirs"));
//        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
//
//        Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();

        DriverManager.getConnection("adas");
    }
}