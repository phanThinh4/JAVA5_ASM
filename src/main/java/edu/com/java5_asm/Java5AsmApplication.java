package edu.com.java5_asm;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Java5AsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java5AsmApplication.class, args);
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("cmd /c start chrome http://localhost:8080/asm");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
