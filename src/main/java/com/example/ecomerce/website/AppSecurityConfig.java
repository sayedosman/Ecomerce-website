package com.example.ecomerce.website;

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

import com.example.ecomerce.website.auth.AppUserDetailServise;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AppUserDetailServise userDetailsService;
  @Bean
  public PasswordEncoder passwordencoder()
  {
	  return new BCryptPasswordEncoder();
  }
	

  
 /*@Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("ahmed@gmail.com")
    .password("$2y$12$IVd6udDo5Z.GQ22SmCrzRu/VS6Lw.70mhFnNBvdT71dlH40NV97lK")
    .roles("INSTRUCTOR");
	auth.inMemoryAuthentication().withUser("sayed@gmail.com")
	.password("$2y$12$IVd6udDo5Z.GQ22SmCrzRu/VS6Lw.70mhFnNBvdT71dlH40NV97lK")
	.roles("STUDENT");
}*/
 @Override
 public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
 	}
 
 
  @Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/web/403").permitAll()
		.antMatchers("/web").hasAuthority("admin")
		.anyRequest()
		.authenticated()
		.and()
	.formLogin().and()
	.httpBasic()
	.and()
	.csrf().disable()
	.exceptionHandling().accessDeniedPage("/web/403")
	.and()
	.userDetailsService(userDetailsService);
	}
	
}
