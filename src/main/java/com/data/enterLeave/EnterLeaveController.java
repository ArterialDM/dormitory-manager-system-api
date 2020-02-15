package com.data.enterLeave;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class EnterLeaveController {

    static GetEnterLeave getEnterLeave=new GetEnterLeave();

    @GetMapping("/enterLeave")
    public String hello(HttpServletRequest request) {
        String query=null;
        try {
            query=getEnterLeave.query();
        }catch (Exception e){
            e.printStackTrace();
        }
        return query;
    }
}
