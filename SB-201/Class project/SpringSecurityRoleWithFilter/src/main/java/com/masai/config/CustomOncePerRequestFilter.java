package com.masai.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomOncePerRequestFilter extends OncePerRequestFilter{

	
	private final Logger log = LoggerFactory.getLogger(CustomOncePerRequestFilter.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		
		

		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		
		
		if(auth != null) {
			
			log.info("User "+auth.getName()+" is successfully authenticated and has Authorties "+ auth.getAuthorities().toString());
		}
		
		chain.doFilter(request, response);
		
	}
	
	
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		

		return !request.getServletPath().equals("/signIn");
		
		
	}
	
	
	
	
	

}
