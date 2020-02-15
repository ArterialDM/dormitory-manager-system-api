package com.data.student.updataStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class UpdateStudent {

    private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1999113WDM";
    private static final String sql = "UPDATE student SET studentID=?,college=?,name=?,date1=?,date2=?,live=?,politics=?,sex=?,`desc`=? WHERE count=?";

    public void query(Map<String,Object> map)throws Exception {

        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, (String) map.get("studentID"));
        ptmt.setString(2, (String) map.get("college"));
        ptmt.setString(3, (String) map.get("name"));
        ptmt.setString(4, String.valueOf(map.get("time1")));
        ptmt.setString(5, String.valueOf(map.get("time2")));
        ptmt.setBoolean(6,(Boolean) map.get("live"));
        ptmt.setString(7, (String) map.get("politics"));
        ptmt.setString(8, (String) map.get("sex"));
        ptmt.setString(9, (String) map.get("desc"));
        ptmt.setInt(10,  (Integer) map.get("count"));
        ptmt.execute();
    }
}
