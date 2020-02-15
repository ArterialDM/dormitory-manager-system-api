package com.data.student.addStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.sql.DriverManager;

public class AddStudent {

    private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1999113WDM";

    public void query(Map<String,Object> map)throws SQLException{

        Connection conn = null;
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO student(studentID, college, bedID, name, date1, date2,live, politics, sex, `desc` ) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, (String) map.get("studentID"));
        ptmt.setString(2, (String) map.get("college"));
        ptmt.setString(3, (String) map.get("bedID"));
        ptmt.setString(4, (String) map.get("name"));
        ptmt.setString(5, String.valueOf(map.get("time1")));
        ptmt.setString(6, String.valueOf(map.get("time2")));
        ptmt.setBoolean(7,(Boolean) map.get("live"));
        ptmt.setString(8, (String) map.get("politics"));
        ptmt.setString(9, (String) map.get("sex"));
        ptmt.setString(10, (String) map.get("desc"));
        ptmt.execute();
        conn.close();
    }
}
