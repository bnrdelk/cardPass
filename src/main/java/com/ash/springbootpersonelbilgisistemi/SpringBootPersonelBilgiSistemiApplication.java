package com.ash.springbootpersonelbilgisistemi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ash.springbootpersonelbilgisistemi.controller,"
		+ "com.ash.springbootpersonelbilgisistemi.service,"
		+ "com.ash.springbootpersonelbilgisistemi.model,"
		+ "com.ash.springbootpersonelbilgisistemi.repository,"
		+ "com.ash.springbootpersonelbilgisistemi.security,"
		+ "com.ash.springbootpersonelbilgisistemi.util"} )
public class SpringBootPersonelBilgiSistemiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPersonelBilgiSistemiApplication.class, args);
	}

}
