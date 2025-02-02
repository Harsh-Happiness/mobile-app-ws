package com.appdeveloperblog.app.ws.security;

import javax.validation.OverridesAttribute;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

		private final UserDetailsService userDetailsService;
		private final BCryptPasswordEncoder bCryptPasswordEncoder;
		
		public WebSecurity(UserDetailsService userDetailsService,
				BCryptPasswordEncoder bCryptPasswordEncoder) {
			this.bCryptPasswordEncoder = bCryptPasswordEncoder;
			this.userDetailsService = userDetailsService;
		}
		
		@Override
		protected void configure(HttpSecurity http ) throws Exception{
			http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,"/users")
			.permitAll().anyRequest().authenticated();
		}
		
		public void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
		}
}
