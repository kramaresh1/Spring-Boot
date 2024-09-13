package com.FirstApp.demo.Controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FirstApp.demo.Entity.Users;
import com.FirstApp.demo.JWT.JwtHelper;
import com.FirstApp.demo.JWT.JwtRequest;
import com.FirstApp.demo.JWT.JwtResponse;
import com.FirstApp.demo.Service.OwnUserService;



@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private OwnUserService onwServeice;



    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

   
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody(required = false) JwtRequest request) {

       Users userDetails = onwServeice.verifyUser(request.getEmail(), request.getPassword());
        if (userDetails!=null) {
        String token = this.helper.generateToken(userDetails);

        JwtResponse response =new  JwtResponse(token,userDetails.getUsername(), "Login successfull");
               
        return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
        	 JwtResponse response =new  JwtResponse("username or password is incorrect ");
        	 return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

   
	@PostMapping("/registration")
    public ResponseEntity<JwtResponse> registerUser(@RequestBody(required = true) Users request) {
		String pass=request.getUpassword();
     	Boolean isSaved=onwServeice.registerUser(request);
     	
     	if (isSaved) {
        Users userDetails = onwServeice.verifyUser(request.getUsername(), pass);
        if (userDetails!=null) {
        String token = this.helper.generateToken(userDetails);

        JwtResponse response =new  JwtResponse(token,userDetails.getUsername(),"Registration successfull");
               
        return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else {
        	JwtResponse response =new  JwtResponse("Registration Failed , Please try again");
        	 return new ResponseEntity<>(response, HttpStatus.OK);
        }
     	}else {
     		JwtResponse response =new  JwtResponse("Registration Failed , Please try again");
     		 return new ResponseEntity<>(response, HttpStatus.OK);
     	}
    }


    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}

