package com.tahir.darkcodder.employee.details.security;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

import com.tahir.darkcodder.employee.details.service.EmployeeService;

@Configuration
@EnableWebSecurity
public class WebSecurity {
	
	private Environment env;
	private EmployeeService employeeService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	
	public WebSecurity(Environment env, EmployeeService employeeService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.env = env;
		this.employeeService = employeeService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}



	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {	
		
		
		System.out.println("==============Security Cinfig================");
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(employeeService).passwordEncoder(bCryptPasswordEncoder);
		AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
        http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable());
		http
	    .authorizeHttpRequests((authorize) -> authorize
	       .requestMatchers("/employees/**").permitAll()
	    		 //.requestMatchers("/employees/**").access(new WebExpressionAuthorizationManager("hasIpAddress('"+env.getProperty("gateway.ip")+"')"))
	        
	       .anyRequest().authenticated()
	    ).addFilter(new AuthenticationFilter(authenticationManager,employeeService,env)).authenticationManager(authenticationManager);
		
		/*
		 * http.cors().and().csrf().disable().authorizeHttpRequests().requestMatchers(
		 * HttpMethod.POST, "/employee") .permitAll().requestMatchers(HttpMethod.GET,
		 * "/fetch").permitAll().and().sessionManagement().sessionCreationPolicy(
		 * SessionCreationPolicy.STATELESS); http.headers().frameOptions().disable();
		 */
		return http.build();

	}

}
