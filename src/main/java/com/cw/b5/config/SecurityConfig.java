package com.cw.b5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// 정적 자원 요청 URL은 Security 거치지 않고 통과
		web.ignoring()
					.antMatchers("/css/**")
					.antMatchers("/js/**")
					.antMatchers("/images/**")
					.antMatchers("/vendor/**")
					.antMatchers("/favicon*/**")
					.antMatchers("/resources/**")
					.antMatchers("/front/**");					
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
			.and()
			.csrf().disable()
			.authorizeRequests()
								.antMatchers("/").permitAll()
								.antMatchers("/notice/selectList", "/notice/selectOne").permitAll()
								//ROLE_를 제외한 나머지 이름
							//	.antMatchers("/notice/insert", "/notice/update", "/notice/delete").hasRole("ADMIN")
								.antMatchers("/notice/**").hasRole("ADMIN")
							//	.antMatchers("/member/memberLogin").permitAll()
								.antMatchers("/member/memberJoin").permitAll()
								.anyRequest().authenticated()
								//위의 antMathchers외에 그 외 나머지는 인증(로그인) 필요
								.and()
			//Security에서는 기본 로그인 폼을 제공					
			//개발자가 만든 로그인 폼으로 이동
			.formLogin()
						.loginPage("/member/memberLogin")
						.defaultSuccessUrl("/")
						//파라미터 이름은 security에서는 username 사용
						.usernameParameter("id")
						.passwordParameter("pw")
						.permitAll()
								;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		//Spring 5 이후부터는 비밀번호 평문으로 저장 금지
		return new BCryptPasswordEncoder();
	}

}
