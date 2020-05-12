package com.jk2k.snakeyamldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class SnakeyamldemoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SnakeyamldemoApplication.class, args);

		Constructor constructor = new Constructor(DemoProperty.class);
		Representer representer = new Representer();
		representer.getPropertyUtils().setSkipMissingProperties(true);
		Yaml yaml = new Yaml(constructor, representer);

		InputStream inputStream = new ClassPathResource("demo.yaml").getInputStream();
		DemoProperty property = yaml.load(inputStream);
		System.out.println(property.getSystem().get("erp"));
	}

}
