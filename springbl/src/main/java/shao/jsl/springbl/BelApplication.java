package shao.jsl.springbl;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@MapperScan("shao.jsl.springbl.mapper")
public class BelApplication {
    private static Logger log = LoggerFactory.getLogger(BelApplication.class);


    public static void main(String[] args) {
        log.warn("abc", new RuntimeException("fsljfsjfl"));
        SpringApplication.run(BelApplication.class, args);
    }



	/*
	@PostMapping("/alertmanager")
	public void alertmanager(@RequestBody Map<String,Object> body ) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		String j=mapper.writeValueAsString(body);
		log.warn(j);
	}*/

}