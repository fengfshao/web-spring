package shao.example.webspring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shao.example.webspring.entity.Actor;
import shao.example.webspring.mapper.ActorMapper;

/**
 * Author: shaoff
 * Date: 2020/8/20 17:25
 * Package: shao.jsl.springbl.service
 * Description:
 */
@Service
public class ActorService {

    @Autowired
    ActorMapper actorMapper;

    public List<Actor> list(int count) {
        return actorMapper.listActor(count);
    }

    public void add(Actor actor) {
        actorMapper.insertActor(actor);
    }

    public Actor find(int actorId) {
        return actorMapper.selectActor(actorId);
    }
}
