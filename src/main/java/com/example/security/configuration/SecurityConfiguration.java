package com.example.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//set your configuration on the auth project
		auth.inMemoryAuthentication()
		.withUser("foo")
		.password("foo")
		.roles("USER")
		.and()
		.withUser("foo1")
		.password("foo1")
		.roles("ADMIN");
	}
	
	
	/**
	 * It allows to use clear text in password, we are disabling the encoding on password.
	 * @return
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}

}
