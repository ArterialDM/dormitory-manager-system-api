package com.data.bed.studentGetBed;

import com.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class StudentGetBedController {

    StudentGetBed studentGetBed=new StudentGetBed();
    static Result result =new Result();

    @PostMapping("/studentAddBed")
    public String hello(@RequestBody Map<String,Object> map) {

        System.out.println(map);
        try {
            if(studentGetBed.studentgetBed(map)){
                return result.success();
            }else {
                return result.fail();
            }
        }catch (Exception e){
            return result.fail();
        }
    }
}
