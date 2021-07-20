package shao.example.webspring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shao.example.webspring.entity.Actor;
import shao.example.webspring.service.ActorService;

/**
 * Author: fengfshao
 * Date: 2020/8/19 19:37
 * Package: shao.example.webspring.controller.EmployeeController
 * Description:
 */

@RestController
@RequestMapping("actor")
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/list")
    public List<Actor> listEmployees(@RequestParam(value = "count", defaultValue = "10") int count) {
        return actorService.list(count);
    }

    @PostMapping("/add")
    public void insertActor(@RequestBody Actor e) {
        actorService.add(e);
    }

    @GetMapping("/find")
    public Actor findActor(@RequestParam int id) {
        return actorService.find(id);
    }
}
