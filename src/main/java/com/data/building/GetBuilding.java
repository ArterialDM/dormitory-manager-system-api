package com.data.building;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetBuilding {

    private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1999113WDM";

    public String query() throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT buildingID,student_live_count,student_lived_count,dormitory_have_count,dormitory_had_count FROM building"); 
        //如果有数据，rs.next()返回true
        JSONArray jsonArray = new JSONArray();
        while(rs.next()){
            //System.out.println(rs.getString("studentID"));
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            map.put("buildingID",rs.getString("buildingID"));
            map.put("student_live_count", rs.getInt("student_live_count"));
            map.put("student_lived_count", rs.getInt("student_lived_count"));
            map.put("dormitory_have_count", rs.getInt("dormitory_have_count"));
            map.put("dormitory_had_count", rs.getInt("dormitory_had_count"));
            JSONObject json = new JSONObject(map);
            jsonArray.put(json);
        }
        conn.close();
        return jsonArray.toString();
    }
}
