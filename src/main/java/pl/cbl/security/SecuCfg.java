package pl.cbl.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "pl.cbl.*")
@EnableJpaRepositories(basePackages = "pl.cbl.*")
public class SecuCfg extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        	http.csrf().disable();
        		http.authorizeRequests().antMatchers("/main", "/register")
        		.permitAll().anyRequest().authenticated()
        		.and()
        		.formLogin().loginPage("/login").permitAll()
        		.loginProcessingUrl("/proces").permitAll()
        		.usernameParameter("username")
        		.passwordParameter("password")
        		.and()
        		.logout()
        		.logoutUrl("/logout")
        		.logoutSuccessUrl("/").permitAll();
    }
	
	
	
}
