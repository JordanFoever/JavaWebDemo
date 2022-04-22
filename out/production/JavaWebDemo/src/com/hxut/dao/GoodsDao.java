package com.hxut.dao;

import com.hxut.model.Goods;
import com.hxut.utils.JDBCUtils;
import com.mysql.jdbc.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsDao {
    //声明Connection
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //查询所有产品信息
    public ArrayList<Goods> findAllGoods(){
        //创建一个产品集合
        ArrayList<Goods> goodsList=new ArrayList<Goods>();
       // 从数据库中查

        try {
            //  1.获取connection对象
            connection = JDBCUtils.getConnection();
            // 2.创建preparedStatement对象
            String sql = "SELECT * from goods";
            preparedStatement = connection.prepareStatement(sql);
            //执行SQL语句 返回ResultSet结果集
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            // 第一个光标指向的是表头
            while (resultSet.next()){
                Goods goods = new Goods();
                goods.setId(resultSet.getInt("id"));
                goods.setName(resultSet.getString("name"));
                goods.setCover(resultSet.getString("cover"));
                goods.setImage1(resultSet.getString("image1"));
                goods.setPrice(resultSet.getFloat("price"));
                goods.setIntro(resultSet.getString("intro"));
                goods.setStock(resultSet.getInt("stock"));
                goodsList.add(goods);
            }
            return goodsList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放数据库资源
            JDBCUtils.release(resultSet,preparedStatement,connection);
        }

        //在执行代码中抛出异常,返回null
        return  null;
    }
}

