package com.hxut.dao;


import com.hxut.model.User;
import com.hxut.utils.JDBCUtils;
// import com.mysql.jdbc.ResultSet;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// import com.mysql.jdbc.ResultSet;

/**
 * @author weijiangquan
 * @date 2022/4/22 -14:13
 *
 *
 */
public class UserDao {

    //声明Connection
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    /**
     * 方法一
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    public User findUserByNameAndPs(String username,String password){

        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT * from user where username=? and password =?";
            preparedStatement = connection.prepareStatement(sql);
            //执行SQL语句 返回ResultSet结果集

            //1 代表的是替换第一个问号
             preparedStatement.setString(1,username);
             preparedStatement.setString(2,password);

             resultSet =  preparedStatement.executeQuery();

            User user = new User();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
            }
            return user;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(resultSet,preparedStatement,connection);
        }

        // 发生异常的话就返回空
        return null;
    }

    /**
     * 方法二
     * @param username
     * @return
     */
    // 获取用户的全部信息(用于注册)
    public User findUserByUsername(String username){
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT * from user where username=?";
            preparedStatement = connection.prepareStatement(sql);
            //执行SQL语句 返回ResultSet结果集

            //1 代表的是替换第一个问号
            preparedStatement.setString(1,username);
            resultSet =  preparedStatement.executeQuery();

            User user = new User();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
            }
            return user;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(resultSet,preparedStatement,connection);
        }

        return null;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user){
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into user (username,email,password,name,phone,address) values(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getName());
            preparedStatement.setString(5,user.getPhone());
            preparedStatement.setString(6,user.getAddress());

            // 新的方法(返回的是)
            int rows = preparedStatement.executeUpdate();
            return rows;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(preparedStatement,connection);
        }
        return 0;
    }
}


