package shao.example.webspring.controller;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: fengfshao
 * Date: 2021/7/20 19:32
 * Package: shao.example.webspring.controller
 * Description:
 */
@Controller
@Slf4j
public class HelloController {

    @GetMapping("/hello") //定向到world.html
    public String hello() {
        return "world";
    }

    @PostMapping(value = "/query")
    @ResponseBody //非RestController，还是要写注解
    public Map<String, String> query(@RequestBody Map<String, String> params) {
        log.info("query {}", params);
        params.entrySet().forEach(en -> {
            String v = en.getValue();
            en.setValue("processed_" + v);
        });
        return params;
    }
}
