package com.data.alloc.getAlloc;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetAlloc {

    private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1999113WDM";

    public String query() throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT count,college,sex,advance_Building FROM alloc");
        //如果有数据，rs.next()返回true
        JSONArray jsonArray = new JSONArray();
        while(rs.next()){
            //System.out.println(rs.getString("studentID"));
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            map.put("count",rs.getInt("count"));
            map.put("college",rs.getString("college"));
            map.put("sex", rs.getString("sex"));
            map.put("advance_Building", rs.getString("advance_Building"));
            JSONObject json = new JSONObject(map);
            jsonArray.put(json);
        }
        conn.close();
        //System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }
}
