package com.data.bed.studentGetBed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class StudentGetBed {

    private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1999113WDM";
    private static final String sql1 = "UPDATE student SET bedID=?,live=true WHERE studentID=?";
    private static final String sql2 = "UPDATE bed SET can='是' WHERE bedID=?";

    public boolean studentgetBed(Map<String,Object> map)throws Exception{

        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);
            PreparedStatement ptmt1 = conn.prepareStatement(sql1);
            PreparedStatement ptmt2 = conn.prepareStatement(sql2);
            ptmt1.setString(1, (String) map.get("bedID"));
            ptmt1.setString(2, (String) map.get("studentID"));
            ptmt2.setString(1, (String) map.get("bedID"));
            ptmt1.execute();
            ptmt2.execute();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
            conn.close();
            return false;
        }
        return true;
    }
}
