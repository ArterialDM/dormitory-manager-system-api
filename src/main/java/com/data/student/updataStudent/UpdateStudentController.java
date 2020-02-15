package com.data.student.updataStudent;

import com.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class UpdateStudentController {

    static UpdateStudent updateStudent =new UpdateStudent();
    static Result result=new Result();

    @PostMapping("/updateStudent")
    public String hello(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        try{
            updateStudent.query(map);
        }catch (Exception e){
            e.printStackTrace();
            return result.fail();
        }
        return result.success();
    }
}
