package com.pinaki.springboot.firstwebapp.springsecurity;

import java.util.function.Function;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static  org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
	//When we make enable spring security
	//It automatically provide login form
	//All links are protected
	//CSRF disabled
	//Frame disable
	
	
	//Hard Coded Password Configuration
	
//	@Bean
//	public InMemoryUserDetailsManager createUserDeatils() {
//		UserDetails userDetails= User.withDefaultPasswordEncoder()
//				.username("Pinaki")
//				.password("123456")
//				.roles("USER","ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(userDetails);
//	}

	//Without Harding the value using password Encoding
	
	@Bean
	public InMemoryUserDetailsManager createUserDeatils() {
		
		UserDetails userDetails = createNewUserNameandPassword("Pinaki", "123456");
		UserDetails userDetails1 = createNewUserNameandPassword("Priya", "123456");
		
		return new InMemoryUserDetailsManager(userDetails,userDetails1);
	}

	
	//Method used to create New UserName and Password
	private UserDetails createNewUserNameandPassword( String username,String password) {
		Function<String, String> passwordEncoder = i -> passwordEncoder().encode(i); 
		UserDetails userDetails= User.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER","ADMIN")
				.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	//When we make enable spring security
		//It automatically provide login form
		//All links are protected
		//CSRF disabled
		//Frame disable
	    //For that securityFilterchain to be override
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	
	httpSecurity.authorizeHttpRequests(
			auth->auth.anyRequest().authenticated()
			);
	httpSecurity.formLogin(withDefaults());
	httpSecurity.csrf().disable();
	httpSecurity.headers().frameOptions().disable();
	return httpSecurity.build();
	}
}
