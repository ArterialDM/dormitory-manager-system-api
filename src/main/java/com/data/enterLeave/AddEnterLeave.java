package com.data.enterLeave;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

public class AddEnterLeave {

    private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1999113WDM";
    static String enterSql = "INSERT INTO enterleave(studentID, action, buildingID, time, `desc` ) values(?,'进入',?,?,?)";
    static String leaveSql = "INSERT INTO enterleave(studentID, action, buildingID, time, `desc` ) values(?,'离开',?,?,?)";

    public void enter(Map<String,Object> map)throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ptmt = conn.prepareStatement(enterSql);
        ptmt.setString(1, (String) map.get("studentID"));
        ptmt.setString(2, (String) map.get("building"));
        String date=((String) map.get("date1")).substring(0, 10);
        String time=((String) map.get("date2")).substring(11, 19);
        String year=date.substring(0,4);
        String month=date.substring(5,7);
        int day=Integer.valueOf(date.substring(8,10))+1;
        int hour=Integer.valueOf(time.substring(0,2));
        if(hour+8==24){
            ptmt.setString(3, year+"-"+month+"-"+day+","+"00"+time.substring(2,8));
        }
        if (9<hour+8&&hour+8<24){
            ptmt.setString(3, year+"-"+month+"-"+day+","+(hour+8)+time.substring(2,8));
        }
        if (hour+8<10){
            ptmt.setString(3, year+"-"+month+"-"+day+","+"0"+(hour+8)+time.substring(2,8));
        }
        if (hour+8>24){
            ptmt.setString(3, year+"-"+month+"-"+day+","+"0"+(hour-16)+time.substring(2,8));
        }
        ptmt.setString(4, (String) map.get("desc"));
        ptmt.execute();
        conn.close();
    }

    public void leave(Map<String,Object> map)throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ptmt = conn.prepareStatement(leaveSql);
        ptmt.setString(1, (String) map.get("studentID"));
        ptmt.setString(2, (String) map.get("building"));
        String date=((String) map.get("date1")).substring(0, 10);
        String time=((String) map.get("date2")).substring(11, 19);
        String year=date.substring(0,4);
        String month=date.substring(5,7);
        int day=Integer.valueOf(date.substring(8,10))+1;
        int hour=Integer.valueOf(time.substring(0,2));
        if(hour+8==24){
            ptmt.setString(3, year+"-"+month+"-"+day+","+"00"+time.substring(2,8));
        }
        if (9<hour+8&&hour+8<24){
            ptmt.setString(3, year+"-"+month+"-"+day+","+(hour+8)+time.substring(2,8));
        }
        if (hour+8<10){
            ptmt.setString(3, year+"-"+month+"-"+day+","+"0"+(hour+8)+time.substring(2,8));
        }
        if (hour+8>24){
            ptmt.setString(3, year+"-"+month+"-"+day+","+"0"+(hour-16)+time.substring(2,8));
        }
        ptmt.setString(4, (String) map.get("desc"));
        ptmt.execute();
    }
}
