package com.function.autoAlloc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class AutoAllocController {
    AutoAlloc autoAlloc = new AutoAlloc();
    @PostMapping("/autoAlloc")
    public String hello(@RequestBody Map<String, Object> map) {
        System.out.println(map);
        String result = null;
        try {
            result = autoAlloc.search(map);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }
}
