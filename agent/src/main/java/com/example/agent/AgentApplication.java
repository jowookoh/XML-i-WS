package com.example.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;

@SpringBootApplication
public class AgentApplication {
	public static void main(String[] args){
		String sema = "muszema";
		int port = 8082;
		if (available(port) == false) {
			port = 8084;
		}

		switch(port){
			case 8082:
				sema = "muszema";
				break;
			case 8084:
				sema = "maszynka";
				break;
		}
		System.out.println("port " + port + " sema " + sema);
		String PREFIX = "jdbc:mysql://localhost:3306/";
		String SUFIX = "?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("server.port", port);
		properties.put("spring.datasource.url", PREFIX + sema + SUFIX);
		new SpringApplicationBuilder(AgentApplication.class)
				.properties(properties)
				.build()
				.run(args);
	}

	private static boolean available(int port) {
		try (Socket ignored = new Socket("localhost", port)) {
			return false;
		} catch (IOException ignored) {
			return true;
		}
	}
}
