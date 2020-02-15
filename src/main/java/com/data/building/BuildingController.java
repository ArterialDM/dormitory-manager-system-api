package com.data.building;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class BuildingController {

    static GetBuilding getBuilding=new GetBuilding();

    @GetMapping("/building")
    public String hello(HttpServletRequest request) {

        String query=null;
        try {
            query=getBuilding.query();
        }catch (Exception e){
            e.printStackTrace();
        }
        return query;
    }
}
