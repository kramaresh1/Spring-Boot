package com.FirstApp.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FirstApp.demo.Entity.Users;
import com.FirstApp.demo.Repo.UserRepository;
import com.FirstApp.demo.Service.OwnUserService;



@RestController
@RequestMapping("/test")
public class HomeController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OwnUserService us;


     @GetMapping("/a")
    public List<Users> test() { 
    	
        return  userRepository.findAll();
    }


}
