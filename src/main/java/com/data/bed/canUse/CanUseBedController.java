package com.data.bed.canUse;

import com.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CanUseBedController {

    static CanUseBed canUseBed =new CanUseBed();
    static Result result =new Result();

    @PostMapping("/canUseBed")
    public String hello(@RequestBody Map<String,Object> map) {

        System.out.println(map);
        String bedID=(String) map.get("bedID");
        try {
            if(canUseBed.canUse(bedID)){
                return result.success();
            }else {
                return result.fail();
            }
        }catch (Exception e){
            e.printStackTrace();
            return result.fail();
        }
    }
}
