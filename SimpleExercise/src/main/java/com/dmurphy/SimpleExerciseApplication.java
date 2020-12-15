package com.dmurphy;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dmurphy.entities.WishList;

import repository.WishListRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=WishListRepo.class)
public class SimpleExerciseApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SimpleExerciseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimpleExerciseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(WishListRepo repo) {
		List<String> list1 = new ArrayList<String>();
		list1.add("Book");
		list1.add("Shoes");
		list1.add("Game");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("Patience");
		list2.add("Health");
		
		List<String> list3 = new ArrayList<String>();
		list3.add("World Peace");
		
		return (args) -> {
			repo.save(new WishList("Jacob", list1));
			repo.save(new WishList("Murph", list2));
			repo.save(new WishList("Joy", list3));
			
			for(WishList wishList: repo.findAll()) {
				log.info(wishList.toString());
			}
		};
	}

}
