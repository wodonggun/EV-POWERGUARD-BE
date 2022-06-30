package com.evpowerguard.registration;


import com.evpowerguard.registration.domain.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface UserRepository extends JpaRepository<User, String>{    // Repository Pattern Interface
    
    User user = new User();

}
