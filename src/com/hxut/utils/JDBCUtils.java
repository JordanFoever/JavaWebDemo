package com.hxut.utils;

import java.sql.*;

/**
 * 这是一个工具类,以后用就行了
 */
public class JDBCUtils {
    // 加载驱动，并建立数据库连接
    public  static Connection getConnection() throws ClassNotFoundException, SQLException {
        //1.加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.通过DriverManager获取数据库连接
        //47.102.222.16 --数据库服务器的地址  3306:数据库服务的端口  cakesdb 数据库名称  useUnicode=true&characterEncoding=utf-8  --解决中文乱码问题
        String url="jdbc:mysql://localhost:3306/cakesdb?useUnicode=true&characterEncoding=utf-8";
        String user="root";
        String password="123456";
         Connection connection =  DriverManager.getConnection(url,user,password);
         return  connection;
    }


    //释放数据库资源-----做修改，删除，更新
    public  static  void release(PreparedStatement preparedStatement,Connection connection){
        //关闭释放preparedStatement对象
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            preparedStatement=null;
        }

   //关闭释放connection对象
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection=null;
        }

    }
    //释放数据库资源-----做查询

    public  static  void release(ResultSet resultSet,PreparedStatement preparedStatement, Connection connection){
        //关闭释放resultSet对象
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet=null;
        }
        release(preparedStatement,connection);

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getConnection());
    }

}

