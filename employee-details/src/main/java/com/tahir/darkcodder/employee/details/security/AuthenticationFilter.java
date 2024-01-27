package com.tahir.darkcodder.employee.details.security;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tahir.darkcodder.employee.details.model.EmployeeDTO;
import com.tahir.darkcodder.employee.details.model.LoginRequest;
import com.tahir.darkcodder.employee.details.service.EmployeeService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private EmployeeService empService;
	private Environment environment;

	public AuthenticationFilter(AuthenticationManager authenticationManager, EmployeeService empService,
			Environment environment) {
		super(authenticationManager);
		this.empService=empService;
		this.environment=environment;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			LoginRequest creds = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
			return getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));
		} catch (Exception e) {
			throw new AuthenticationCredentialsNotFoundException("Wrong username or password");
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String userName = ((User) authResult.getPrincipal()).getUsername();
		EmployeeDTO empDTO = empService.getEmployeeDetailsByEmail(userName);
		String tokenSecret = environment.getProperty("token.secret");
		byte[] secretBytes = Base64.getEncoder().encode(tokenSecret.getBytes());
		//SecretKey secretKey = new SecretKeySpec(secretBytes, SignatureAlgorithm.HS512.getJcaName());
		SecretKey secretKey =Keys.hmacShaKeyFor(secretBytes);
		String token = Jwts.builder().subject(empDTO.getEmployeeId())
				.expiration(Date
						.from(Instant.now().plusMillis(Long.parseLong(environment.getProperty("token.expiration")))))
				.issuedAt(Date.from(Instant.now())).signWith(secretKey).compact();//signWith(secretKey, SignatureAlgorithm.HS512).compact();
		response.addHeader("token", token);
		response.addHeader("employeeId", empDTO.getEmployeeId());

	}
}
