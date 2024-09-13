package com.FirstApp.demo.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Users  implements UserDetails{
//	    @Id
//	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
//	    @SequenceGenerator(name = "user_sequence", sequenceName = "USER_SEQ", allocationSize = 1)
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	  //  private Long id;
	    private int uusertype_id;
	    private int ulogin_attempt; 
	    private String ugender;
	    private String uusername;
	    private String upassword;
	    private String ufname;
	    private String ulname;
	    private String upriv_password;
	    private String ustate;
	    private Date ucreated_date;
		public Users(Long id, int uusertype_id, int ulogin_attempt, String ugender, String uusername, String upassword,
				String ufname, String ulname, String upriv_password, String ustate, Date ucreated_date) {
			super();
			this.id = id;
			this.uusertype_id = uusertype_id;
			this.ulogin_attempt = ulogin_attempt;
			this.ugender = ugender;
			this.uusername = uusername;
			this.upassword = upassword;
			this.ufname = ufname;
			this.ulname = ulname;
			this.upriv_password = upriv_password;
			this.ustate = ustate;
			this.ucreated_date = ucreated_date;
		}
		public Users() {

		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public int getUusertype_id() {
			return uusertype_id;
		}
		public void setUusertype_id(int uusertype_id) {
			this.uusertype_id = uusertype_id;
		}
		public int getUlogin_attempt() {
			return ulogin_attempt;
		}
		public void setUlogin_attempt(int ulogin_attempt) {
			this.ulogin_attempt = ulogin_attempt;
		}
		public String getUgender() {
			return ugender;
		}
		public void setUgender(String ugender) {
			this.ugender = ugender;
		}
		public String getUusername() {
			return uusername;
		}
		public void setUusername(String uusername) {
			this.uusername = uusername;
		}
		public String getUpassword() {
			return upassword;
		}
		public void setUpassword(String upassword) {
			this.upassword = upassword;
		}
		public String getUfname() {
			return ufname;
		}
		public void setUfname(String ufname) {
			this.ufname = ufname;
		}
		public String getUlname() {
			return ulname;
		}
		public void setUlname(String ulname) {
			this.ulname = ulname;
		}
		public String getUpriv_password() {
			return upriv_password;
		}
		public void setUpriv_password(String upriv_password) {
			this.upriv_password = upriv_password;
		}
		public String getUstate() {
			return ustate;
		}
		public void setUstate(String ustate) {
			this.ustate = ustate;
		}
		public Date getUcreated_date() {
			return ucreated_date;
		}
		public void setUcreated_date(Date ucreated_date) {
			this.ucreated_date = ucreated_date;
		}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			  List<GrantedAuthority> authorities = new ArrayList<>();
			    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			    return authorities;
		}
		@Override
		public String getPassword() {
			return upassword;
		}
		@Override
		public String getUsername() {
			return uusername;
		}
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
 		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
	   
	   
	  
}
