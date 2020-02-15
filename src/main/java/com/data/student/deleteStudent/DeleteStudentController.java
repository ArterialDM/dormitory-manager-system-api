package com.data.student.deleteStudent;

import com.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class DeleteStudentController {

    static Result result=new Result();
    static DeleteStudent deleteStudent=new DeleteStudent();

    @PostMapping("/deleteStudent")
    public String hello(@RequestBody Map<String,Object> map) {

        System.out.println(map);
        int count=Integer.valueOf((String) map.get("count"));
        try {
            deleteStudent.delete(count);
        }catch (Exception e){
            e.printStackTrace();
            return result.fail();
        }
        return result.success();
    }
}
