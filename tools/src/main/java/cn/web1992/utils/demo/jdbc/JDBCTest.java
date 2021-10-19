package cn.web1992.utils.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author web1992
 * @date 2021/9/30  10:22 上午
 */
public class JDBCTest {

    static final String USER = "root";
    static final String PASS = "root";
    static final String DB_URL = "jdbc:mysql://localhost:3306/seata";

    public static void main(String[] args) throws Exception {


        updateTest();

    }


    public static void updateTest() throws Exception {
        System.out.println("Connecting to database...");
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
        con.setAutoCommit(false);
        //1、导入驱动jar包
        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        boolean autoCommit = con.getAutoCommit();
        System.out.println("autoCommit is: " + autoCommit);
        //4、定义sql语句
        String sql = "update t_order set count= count+1 where id =64";

        //5、获取执行sql语句的对象
        Statement stat = con.createStatement();

        //6、执行sql并接收返回结果
        long count = stat.executeLargeUpdate(sql);
        //7、处理结果
        System.out.println(count);

        // con.rollback();
        // con.commit();
        //8、释放资源
        stat.close();
        con.close();
    }

    public static void queryTest() throws Exception {
        System.out.println("Connecting to database...");
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
        //1、导入驱动jar包
        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //4、定义sql语句
        String sql = "SELECT * FROM seata.t_order";

        //5、获取执行sql语句的对象
        Statement stat = con.createStatement();

        //6、执行sql并接收返回结果
        ResultSet resultSet = stat.executeQuery(sql);
        //7、处理结果
        while (resultSet.next()) {
            System.out.println(resultSet.getLong(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getLong(5));
            System.out.println(resultSet.getDouble(6));
        }

        //8、释放资源
        stat.close();
        con.close();
    }
}
