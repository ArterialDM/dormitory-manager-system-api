package com.data.student.getStudent;

import com.data.student.getStudent.GetStudent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class GetStudentController {

    static GetStudent getStudent=new GetStudent();

    @GetMapping("/student")
    public String hello(HttpServletRequest request) {

        String query=null;
        try {
            query=getStudent.query();
        }catch (Exception e){
            e.printStackTrace();
        }
        return query;
    }
}
