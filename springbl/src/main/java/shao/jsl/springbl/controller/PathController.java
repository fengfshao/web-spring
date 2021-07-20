package shao.jsl.springbl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Author: shaoff
 * Date: 2021/7/16 15:00
 * Package: shao.jsl.springbl.controller
 * Description:
 */
@RestController
@Slf4j
public class PathController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> query(@RequestBody Map<String, String> params) {
        log.warn("query");
        params.entrySet().forEach(en -> {
            String v = en.getValue();
            en.setValue("processed_" + v);
        });
        return params;
    }
}
