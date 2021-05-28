package com.io.springboot.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.io.springboot.commonutils.JwtUtils;
import com.io.springboot.service.UserService;

@Component
public class JwtRequestfilter extends OncePerRequestFilter{

	@Autowired
	UserService userService;
	
	@Autowired
	JwtUtils jwtUtil;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
				
		
		final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;
        

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
        	jwtToken=authorizationHeader.substring(7);
            username = this.jwtUtil.extractUsername(jwtToken);
        }


        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.userService.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }else {
        	//System.out.println("token is not validated");
        } 
        filterChain.doFilter(request, response);
		 
	}

	
	

}
