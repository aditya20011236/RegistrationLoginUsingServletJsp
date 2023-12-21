package com.mydata.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {

    private static String dName="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/profoundproject";

    private static String userName="root";

    private static String passWord="26122001";

    public static Connection initConnection(){

        Connection con=null;
        try{
            Class.forName(dName);

            con= DriverManager.getConnection(url,userName,passWord);


        }catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}
