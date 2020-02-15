package com.function.autoAlloc;

import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class AutoAlloc {
    private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1999113WDM";
    private static final String sql = "SELECT bed.bedID FROM  alloc,bed WHERE college=? AND sex=? AND alloc.advance_Building=bed.buildingID AND can='否'";
    public String search(Map<String,Object> map)throws Exception{
        JSONObject json=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, (String) map.get("college"));
            ptmt.setString(2, (String) map.get("sex"));
            ResultSet rs = ptmt.executeQuery();
            Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
            if(rs.next()) {
                map.put("bedID", rs.getString("bedID"));
            }else{
                map.put("bedID", "");
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
