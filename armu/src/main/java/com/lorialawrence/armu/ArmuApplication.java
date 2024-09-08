package com.lorialawrence.armu;

import com.lorialawrence.armu.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArmuApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ArmuApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.main();
	}

}
