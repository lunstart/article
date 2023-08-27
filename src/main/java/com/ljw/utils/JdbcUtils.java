package com.ljw.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Admin
 *获取连接
 */
public class JdbcUtils {
    private static DruidDataSource dataSource;
        static{
            Properties properties = null;

            try {
                properties = new Properties();
//                从流中加载数据
//                InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("Jdbc.properties");
//                读取配置文件
                properties.load(new FileInputStream("src/main/resources/Jdbc.properties"));
                //创建数据库连接池
                dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
                //System.out.println(dataSource.getConnection());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static Connection getConnection(){
            Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void close(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
