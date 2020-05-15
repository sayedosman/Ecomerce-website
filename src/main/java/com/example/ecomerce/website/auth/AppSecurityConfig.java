package com.example.ecomerce.website.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.ui.LoginPageGeneratingWebFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	private final String[] url= {
			"/luxury",
			"/luxury/auth/login"
			
	};
	@Autowired
	private AppUserDetailServise userDetailsService;
  @Bean
  public PasswordEncoder passwordencoder()
  {
	  return new BCryptPasswordEncoder();
  }
	
 @Override
 public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
 	}
 
 
  @Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers(url).permitAll()
		.antMatchers("/web").hasAuthority("admin")
		.anyRequest()
		.authenticated()
		.and()
	.formLogin().loginPage("/luxury/auth/login").and()
	.httpBasic()
	.and()
	
	.exceptionHandling().accessDeniedPage("/web/403")
	.and()
	.userDetailsService(userDetailsService);
	}
	
}
