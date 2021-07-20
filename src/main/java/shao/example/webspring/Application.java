package shao.example.webspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("shao.example.webspring.mapper") //mybatis-spring生成实际的dao对象
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}