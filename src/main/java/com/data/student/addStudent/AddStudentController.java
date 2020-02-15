package com.data.student.addStudent;

import com.data.student.addStudent.AddStudent;
import com.result.Result;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class AddStudentController {

    static AddStudent addStudent=new AddStudent();
    static Result result=new Result();

    @PostMapping("/addStudent")
    public String hello(@RequestBody Map<String,Object> map) {

        System.out.println(map);
        try{
            addStudent.query(map);
        }catch (Exception e){
            e.printStackTrace();
            return result.fail();
        }
        return result.success();
    }
}
