package com.example.demo_data.jwt;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JavaAuthfilter  extends OncePerRequestFilter {

    private final Jeneratetoken jToken; 
    JavaAuthfilter( Jeneratetoken jToken){
        this.jToken = jToken; 

    }
     
    protected void doFilterInternal(HttpServletRequest request , HttpServletResponse  response , FilterChain filterChain) throws IOException, ServletException, java.io.IOException{
        String Autheheader = request.getHeader("Authorization");
        String token = null ; 
        String email = null; 
        // check bearer token hai ya nahi ; 
        if(Autheheader != null && Autheheader.startsWith("Bearer")){
            // bearer hatao ; 
            token = Autheheader.substring(7);
            email = jToken.extract(token);
            
        }
        if(email!= null &&  SecurityContextHolder.getContext().getAuthentication()== null){
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, null , Collections.emptyList());
            authenticationToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext()
            .setAuthentication(authenticationToken);
        }
          filterChain.doFilter(request, response);
    }
}
