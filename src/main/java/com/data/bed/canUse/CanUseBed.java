package com.data.bed.canUse;

import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CanUseBed {

    private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1999113WDM";
    private static final String sql = "select * from  bed where bedID=?";

    public Boolean canUse(String bedID)throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, bedID);
        ResultSet rs = ptmt.executeQuery();
        if (rs.next()){
            if(((String)rs.getString("can")).equals("否")){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
