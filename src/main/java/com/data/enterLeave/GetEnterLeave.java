package com.data.enterLeave;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetEnterLeave {
    private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1999113WDM";

    public String query() throws Exception{
    
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT count,studentID,action,buildingID,time FROM enterleave");
        //如果有数据，rs.next()返回true
        JSONArray jsonArray = new JSONArray();
        while(rs.next()){
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            map.put("count",rs.getInt("count"));
            map.put("studentID", rs.getString("studentID"));
            map.put("action", rs.getString("action"));
            map.put("buildingID", rs.getString("buildingID"));
            map.put("time", rs.getString("time"));
            JSONObject json = new JSONObject(map);
            jsonArray.put(json);
        }
        conn.close();
        return jsonArray.toString();
    }
}
