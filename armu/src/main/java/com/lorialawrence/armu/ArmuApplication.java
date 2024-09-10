package com.lorialawrence.armu;

import com.lorialawrence.armu.main.Main;
import com.lorialawrence.armu.repository.ArtistaRepository;
import com.lorialawrence.armu.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArmuApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository artistaRepository;
	@Autowired
	private MusicaRepository musicaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ArmuApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(artistaRepository, musicaRepository);
		main.menu();
	}

}
