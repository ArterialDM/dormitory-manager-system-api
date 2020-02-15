package com.data.alloc.getAlloc;

import com.data.alloc.getAlloc.GetAlloc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class GetAllocController {

    static GetAlloc getAlloc=new GetAlloc();

    @GetMapping("/alloc")
    public String hello(HttpServletRequest request) {
        String query=null;
        try {
            query=getAlloc.query();
        }catch (Exception e){
            e.printStackTrace();
        }
        return query;
    }
}
