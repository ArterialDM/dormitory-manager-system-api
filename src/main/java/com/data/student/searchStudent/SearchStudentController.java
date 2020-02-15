package com.data.student.searchStudent;

import com.data.student.searchStudent.SearchStudent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class SearchStudentController {

    static SearchStudent searchStudent=new SearchStudent();

    @PostMapping("/searchStudent")
    public String hello(@RequestBody Map<String,Object> map) {

        System.out.println(map);
        String studentID=(String) map.get("studentID");
        return searchStudent.search(studentID);
    }
}
