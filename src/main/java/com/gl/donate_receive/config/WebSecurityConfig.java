package com.gl.donate_receive.config;

import com.gl.donate_receive.service.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
	prePostEnabled = true,
	securedEnabled = true)
public class WebSecurityConfig {

	@Autowired
	private AuthenticatedUserService authenticatedUserService;

	@Autowired
	private WebAuthenticationProvider webAuthenticationProvider;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Bean
	protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
			.antMatchers("/users").permitAll()
			.antMatchers(HttpMethod.GET, "/home").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/form-login")
			.loginProcessingUrl("/form-login")
			.defaultSuccessUrl("/home")
			.failureUrl("/form-login?error=true")
			.permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/form-login")
			.deleteCookies("JSESSIONID")
			.permitAll();

		return httpSecurity.build();
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(webAuthenticationProvider);
		auth.userDetailsService(authenticatedUserService)
			.passwordEncoder(bCryptPasswordEncoder);
	}

}
