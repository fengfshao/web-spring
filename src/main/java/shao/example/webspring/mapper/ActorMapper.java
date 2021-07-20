package shao.example.webspring.mapper;

import java.util.List;
import shao.example.webspring.entity.Actor;
import shao.example.webspring.entity.Employee;

/**
 * Author: fengfshao
 * Date: 2021/7/20 19:41
 * Package: shao.example.webspring.mapper
 * Description:
 */
public interface ActorMapper {
    List<Actor> listActor(int n);
    Actor selectActor(int actorId);
    void insertActor(Actor actor);
}
