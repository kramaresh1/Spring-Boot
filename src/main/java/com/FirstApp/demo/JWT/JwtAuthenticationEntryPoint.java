package com.FirstApp.demo.JWT;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {


	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		   System.out.println("JwtAuthenticationEntryPoint");
		   response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		 PrintWriter writer = response.getWriter();
		 writer.println("Access Denied 1!! " + authException.getMessage());
		
	}
}