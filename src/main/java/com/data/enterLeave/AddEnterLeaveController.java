package com.data.enterLeave;

import com.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class AddEnterLeaveController {

    static AddEnterLeave addEnterLeave=new AddEnterLeave();
    static Result result=new Result();

    @PostMapping("/addStudentEnter")
    public String enter(@RequestBody Map<String,Object> map) {

        System.out.println(map);
        try{
            addEnterLeave.enter(map);
        }catch (Exception e){
            e.printStackTrace();
            return result.fail();
        }
        return result.success();
    }

    @PostMapping("/addStudentLeave")
    public String leave(@RequestBody Map<String,Object> map) {

        System.out.println(map);
        try {
            addEnterLeave.leave(map);
        }catch (Exception e){
            e.printStackTrace();
            return result.fail();
        }
        return result.success();
    }
}
