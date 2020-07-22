package com.uin2020.crud_registro.securityConfig.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.uin2020.crud_registro.Service.DetalleUsuarioServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/","login").permitAll()
			.antMatchers("/admin*","/AdminProducts").access("hasRole('ADMIN')")
			.antMatchers("/user*","/UserProducts").access("hasRole('USER')")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/menuCategorias")
				.failureUrl("/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
			.logout()
				.permitAll()
				.logoutSuccessUrl("/login?logout");
	}
	
	BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder codificadorPassword() {
		passwordEncoder = new BCryptPasswordEncoder(4);
		return passwordEncoder;
	}


	 @Autowired
	    DetalleUsuarioServiceImpl userDetailsService;
		
	    //Registra el service para usuarios 
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
	
	        auth.userDetailsService(userDetailsService).passwordEncoder(codificadorPassword());  
	    }
	
}
