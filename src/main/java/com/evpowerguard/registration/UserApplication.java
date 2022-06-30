package com.evpowerguard.registration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;


import com.evpowerguard.registration.domain.*;
//import com.h2.examples.H2FileDatabaseExample;
import com.evpowerguard.registration.example.Groomable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 
 * 
 *  followings are httpie scripts to test scenario
 
 http localhost:8080/dogs name='멍멍이' energy=2
 http "http://localhost:8080/pets/1"
 http localhost:8080/cats name='야옹이' energy=2
 http "http://localhost:8080/pets/2"
 http PUT "http://localhost:8080/pets/2/feed"
 http "http://localhost:8080/pets/2"


 http PUT "http://localhost:8080/pets/1/groom"
 http PUT "http://localhost:8080/pets/2/groom"





 ****  REST MM 3 => HATEOAS API ****
{
    "_links": {
        "cat": {
            "href": "http://localhost:8080/cats/2"
        }, 
        "self": {
            "href": "http://localhost:8080/cats/2"
        },
        "feed": {
            "href": "http://localhost:8080/cats/2/feed"
        },
        "groom": {
            "href": "http://localhost:8080/cats/2/groom"
        }
    }, 
    "energy": 3, 
    "name": "야옹이"
}
 * 
 * 
 */


@SpringBootApplication
@RestController
@EnableAspectJAutoProxy


@CrossOrigin("*")
public class UserApplication {


	public static void main(String[] args) {

		// User user = new User();

		// System.out.println("energy is " + user.getEnergy());

		// user.eat();
		// System.out.println("energy is " + user.getEnergy());

		// user.sleep();
		// System.out.println("energy is " + user.getEnergy());

		SpringApplication.run(UserApplication.class, args);
	}


	


	@Autowired
	UserRepository userRepository;



	@RequestMapping(method = RequestMethod.PUT, path="users/{userId}/feed")
	public String feedUser(@PathVariable(value = "userId") String userId){

		User theUser = userRepository.findById(userId).get();

		//theUser.eat();

		userRepository.save(theUser);

		return "맛있는 거 먹였습니다.";
	}


	@RequestMapping(method = RequestMethod.PUT, path="users/{userId}/groom")
	public String groomUser(@PathVariable(value = "userId") String userId){
		User theUser = userRepository.findById(userId).get();

		if(theUser instanceof Groomable){
			String message = ((Groomable)theUser).grooming();
			userRepository.save(theUser);
			return message;
		}

		return "그루밍이 불가능한 user 입니다";
	}

	@RequestMapping(method = RequestMethod.PUT, path="Customers/{userId}/groom")
	public String groomCat(@PathVariable(value = "userId") String userId){
		return groomUser(userId);
	}


	@RequestMapping(method = RequestMethod.PUT, path="Customers/{petId}/feed")
	public String feedCat(@PathVariable(value = "userId") String userId){
		return feedUser(userId);
	}

	@RequestMapping(method = RequestMethod.PUT, path="Managers/{petId}/feed")
	public String feedDog(@PathVariable(value = "userId") String userId){
		return feedUser(userId);
	}

	@RequestMapping(method = RequestMethod.GET, path="/api/user2")
	public String checkLogin(@PathVariable(value = "userId") String userId){
		System.out.println("app 내부");
		return feedUser(userId);
	}

}
