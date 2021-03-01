package pl.tomozak.learningAmigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class LearningAmigoscodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningAmigoscodeApplication.class, args);
	}


//	@GetMapping
//	public String hello(){
//		return "Everything works properly add same new data :)";
//	}

	@GetMapping
	public List<String> hello(){
		return List.of("Everything", "works", "properly", "add same", "new data :)");
	}

}
