package com.data.alloc.deleteAlloc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteAlloc {

    private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1999113WDM";
    static String sql = "DELETE FROM alloc WHERE count=?";
    
    public void delete(int count)throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, count);
        ptmt.execute();
        conn.close();
    }
}
