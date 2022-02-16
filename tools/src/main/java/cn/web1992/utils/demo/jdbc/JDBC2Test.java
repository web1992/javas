package cn.web1992.utils.demo.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author web1992
 * @date 2021/9/30  10:22 上午
 */
public class JDBC2Test {

    static final String USER = "root";
    static final String PASS = "123456";
    static final String DB_URL = "jdbc:mysql://47.102.137.103:3306/yianhealth";
    static DataSource ds = null;

    static {
        //加载配置文件
        Properties pro = new Properties();
        try {
            pro.load(JDBC2Test.class.getClassLoader().getResourceAsStream("druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取DataSource

        try {
            ds = DruidDataSourceFactory.createDataSource(pro);
            //Connection conn = ds.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {


        ExecutorService executorService = Executors.newFixedThreadPool(2000);

        CountDownLatch cdl = new CountDownLatch(2000);
        for (int i = 0; i < 2000; i++) {
            int a = i;
            executorService.submit(() -> {
                try {
                    updateTest();
                    cdl.countDown();
                    System.out.println(a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        cdl.await();
        executorService.shutdown();
    }


    public static void updateTest() throws Exception {
        //System.out.println("Connecting to database...");
        //Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
        Connection con = ds.getConnection();
//        con.setAutoCommit(false);
        //1、导入驱动jar包
        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        boolean autoCommit = con.getAutoCommit();
        //System.out.println("autoCommit is: " + autoCommit);
        //4、定义sql语句
        String sql = "update t_tmp set nums= nums+1 where id =3";

        //5、获取执行sql语句的对象
        Statement stat = con.createStatement();

        //6、执行sql并接收返回结果
        long count = stat.executeUpdate(sql);
        //7、处理结果
//        System.out.println(count);

        // con.rollback();
//        con.commit();
        //8、释放资源
        stat.close();
        con.close();
    }

}
