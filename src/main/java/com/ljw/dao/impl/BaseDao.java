package com.ljw.dao.impl;

import com.ljw.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Admin
 */
public abstract class BaseDao {
     public QueryRunner queryRunner = new  QueryRunner();

    /**
     * @param sql
     * @param args
     * update()用来执行Insert\Updete\Delete语句
     * @return 返回影响行数，-1为失败
     */
     public int update(String sql,Object...args){
         Connection connection = null;

         try {
             connection = JdbcUtils.getConnection();
             return queryRunner.update(connection,sql,args);
         } catch (SQLException e) {
             e.printStackTrace();
         }finally {
             JdbcUtils.close(connection);
         }
         return -1;
     }

    /**
     *查询返回javaBean的sql语句
     * @param type   返回的对象类型
     * @param sql    执行sql语句
     * @param args   sql对应参数值
     * @param <T>    返回的类型的泛型
     * @return
     */

     public <T> T queryForOne(Class<T> type,String sql,Object...args){
         Connection connection = JdbcUtils.getConnection();
         try {
             return queryRunner.query(connection,sql,new BeanHandler<>(type),args);
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             JdbcUtils.close(connection);
         }
         return null;
     }

    /**
     *查询返回多个javaBean的sql语句
     * @param type   返回的对象类型
     * @param sql    执行sql语句
     * @param args   sql对应参数值
     * @param <T>    返回的类型的泛型
     * @return
     */
     public <T> List<T> queryForList(Class<T> type, String sql,Object...args){
         Connection connection = JdbcUtils.getConnection();
         try {
             return queryRunner.query(connection,sql,new BeanListHandler<>(type),args);
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             JdbcUtils.close(connection);
         }
         return null;
     }

    /**
     * 执行返回一行一列sql语句
     * @param sql   执行sql语句
     * @param args  sql对应参数值
     * @return
     */
     public Object queryForSingleValue(String sql,Object...args){
         Connection connection = JdbcUtils.getConnection();

         try {
             return queryRunner.query(connection,sql,new ScalarHandler(),args);
         } catch (SQLException e) {
             e.printStackTrace();
         }finally {
             JdbcUtils.close(connection);
         }
         return null;
     }


}
