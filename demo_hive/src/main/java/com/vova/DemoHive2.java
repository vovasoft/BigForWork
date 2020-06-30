package com.vova;


import java.sql.*;

/**
 * 通过hiveservice2进行jdbc查询
 * @author WangYang - vova
 * @version Create in 5:13 PM 2020/6/29
 */


public class DemoHive2 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:hive2://h11:10000", "vova", "");
        
        String sql = "select * from default.person";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name")+", "+resultSet.getInt("age"));
        }
        
        
    }
}
