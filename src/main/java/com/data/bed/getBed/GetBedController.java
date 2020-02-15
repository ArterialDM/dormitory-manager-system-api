package com.data.bed.getBed;

import com.data.bed.getBed.GetBed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class GetBedController {

    static GetBed getBed=new GetBed();

    @GetMapping("/bed")
    public String hello(HttpServletRequest request) {

        String query=null;
        try {
            query=getBed.query();
        }catch (Exception e){
            e.printStackTrace();
        }
        return query;
    }
}
