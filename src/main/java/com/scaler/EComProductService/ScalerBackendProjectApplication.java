package com.scaler.EComProductService;

import com.scaler.EComProductService.service.impl.InitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScalerBackendProjectApplication  implements CommandLineRunner {

	InitServiceImpl initService;

	@Autowired
	public ScalerBackendProjectApplication(InitServiceImpl initService) {
		this.initService = initService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ScalerBackendProjectApplication.class, args);
	}

	public void run(String[] args) throws Exception
	{
		initService.initialize();
	}
}
