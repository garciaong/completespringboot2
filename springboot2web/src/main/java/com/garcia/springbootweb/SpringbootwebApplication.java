package com.garcia.springbootweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class SpringbootwebApplication implements CommandLineRunner{

//	private Logger log = LoggerFactory.getLogger(SpringbootwebApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebApplication.class, args);
		/** To customized and turn off the banner during start up
		SpringApplication app = new SpringApplication(SpringbootwebApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
	    app.run(args);
	    */
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Running this before Springboot run method completes...");
	}
	

}
