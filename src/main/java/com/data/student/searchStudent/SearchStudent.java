package com.data.student.searchStudent;

import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class SearchStudent {

    private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1999113WDM";
    private static final String sql = "select * from  student where studentID=?";

    public String search(String studentID){

        JSONObject json=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, studentID);
            ResultSet rs = ptmt.executeQuery();
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            if(rs.next()) {
                map.put("count", rs.getInt("count"));
                map.put("studentID", rs.getString("studentID"));
                map.put("college", rs.getString("college"));
                map.put("bedID", rs.getString("bedID"));
                map.put("name", rs.getString("name"));
                map.put("time1", rs.getString("date1"));
                map.put("time2", rs.getString("date2"));
                map.put("live", rs.getBoolean("live"));
                map.put("politics", rs.getString("politics"));
                map.put("sex", rs.getString("sex"));
                map.put("desc", rs.getString("desc"));
            }else{
                map.put("name", "");
            }
            json = new JSONObject(map);
            System.out.println(json.toString());
            conn.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return json.toString();
    }
}
