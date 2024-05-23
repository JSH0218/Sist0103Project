package boot.mvc.quiz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("boot.controller")
@MapperScan("book.data")
public class SpringBootMybatisQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisQuizApplication.class, args);
	}

}
