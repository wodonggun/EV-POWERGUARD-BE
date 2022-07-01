package com.evpowerguard.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.evpowerguard.registration.domain.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("*")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("api/user1")
    public List<User> getUsers()
    {
        System.out.println("userContoller : "+this.userRepository.findAll());
        return this.userRepository.findAll();
    }
    
    
  

}
