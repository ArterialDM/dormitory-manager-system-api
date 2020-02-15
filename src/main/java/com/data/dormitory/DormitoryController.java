package com.data.dormitory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class DormitoryController {

    static GetDormitory getDormitory=new GetDormitory();

    @GetMapping("/dormitory")
    public String hello(HttpServletRequest request) {

        String query=null;
        try {
            query=getDormitory.query();
        }catch (Exception e){
            e.printStackTrace();
        }
        return query;
    }
}
