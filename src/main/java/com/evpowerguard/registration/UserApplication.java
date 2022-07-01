package com.evpowerguard.registration;

import com.evpowerguard.registration.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy


@CrossOrigin("*")
public class UserApplication {


	public static void main(String[] args) {

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

		// if(theUser instanceof Groomable){
		// 	String message = ((Groomable)theUser).grooming();
		// 	userRepository.save(theUser);
		// 	return message;
		// }

		return "그루밍이 불가능한 user 입니다";
	}

	@RequestMapping(method = RequestMethod.PUT, path="Customers/{userId}/groom")
	public String groomCat(@PathVariable(value = "userId") String userId){
		return groomUser(userId);
	}

	@RequestMapping(method = RequestMethod.GET, path="/api/user2")
	public String checkLogin(@PathVariable(value = "userId") String userId){
		System.out.println("app 내부");
		return feedUser(userId);
	}

}
