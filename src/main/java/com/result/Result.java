package com.result;

import org.json.JSONObject;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    static public String success(){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("result","success");
        JSONObject json = new JSONObject(map);
        return json.toString();
    }

    static public String fail(){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("result","fail");
        JSONObject json = new JSONObject(map);
        return json.toString();
    }
}
