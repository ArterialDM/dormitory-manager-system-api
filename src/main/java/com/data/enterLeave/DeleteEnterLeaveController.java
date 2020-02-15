package com.data.enterLeave;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class DeleteEnterLeaveController {

    static DeleteEnterLeave deleteEnterLeave=new DeleteEnterLeave();

    @PostMapping("/deleteEnterLeave")
    public void hello(@RequestBody Map<String,Object> map) {

        System.out.println(map);
        deleteEnterLeave.delete((Integer) map.get("count"));
    }
}
