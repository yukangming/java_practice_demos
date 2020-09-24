package com.yukangming.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/comment?useSSL=false", "root", "ykm18325240045");
        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println("some errors occur");
            e.printStackTrace();
        }
        return conn;
    }
}
