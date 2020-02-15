package com.data.alloc.deleteAlloc;

import com.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class DeleteAllocController {

    static Result result=new Result();
    static DeleteAlloc deleteAlloc=new DeleteAlloc();

    @PostMapping("/deleteAlloc")
    public String hello(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        try {
            deleteAlloc.delete((Integer) map.get("count"));
        }catch (Exception e){
            e.printStackTrace();
            return result.fail();
        }
        return result.success();
    }
}
