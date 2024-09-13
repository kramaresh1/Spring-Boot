package com.FirstApp.demo.Service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.FirstApp.demo.Entity.Users;
import com.FirstApp.demo.Repo.UserRepository;

@Service
public class OwnUserService implements UserDetailsService{
        @Autowired
	   UserRepository userRepo;
        
        private   PasswordEncoder passwordEncoder=null;
     
        public OwnUserService(PasswordEncoder passwordEncoder) {         
            this.passwordEncoder = passwordEncoder;
        }

	
	  @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  try {	
	        Users user = userRepo.findByuusername(username);
	        if (user != null) {
	        	  return org.springframework.security.core.userdetails.User
	  	                .withUsername(user.getUusername())
	  	                .password(user.getUpassword())
	  	                .roles("USER")
	  	                .build();
	        }
		  } catch (Exception e) {
				System.out.println(e);
			}
	        return null;
	    }

	  
	  
	  public Users verifyUser(String username,String password) throws UsernameNotFoundException {
		  Users user=null;
		  try {	      
		       user = userRepo.findByuusername(username);
	        if (user != null) {
	        	 if(!passwordEncoder.matches(password, user.getUpassword())) {
	 	        	
	        		 user=null;
		        }
	        }
	      } catch (Exception e) {
				System.out.println(e);
			}
	      return user;
	    }
	   public boolean registerUser(Users user) {
		   boolean isUserSaved=false;
		   try {
			     user.setUpassword(passwordEncoder.encode(user.getUpassword()));
		         user.setUpriv_password(passwordEncoder.encode(user.getUpassword())); 
		         Calendar calendar = Calendar.getInstance();
		         user.setUcreated_date(calendar.getTime());
		         userRepo.save(user);
		         isUserSaved=true;
		} catch (Exception e) {
			System.out.println(e);
		}
	       
	      return isUserSaved;

	    }

}
