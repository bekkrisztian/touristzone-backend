package ro.touristzone.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 	@Resource(name = "userService")
	    private UserDetailsService userDetailsService;

	    @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Autowired
	    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService)
	                .passwordEncoder(encoder());
	    }

	    @Bean
	    public BCryptPasswordEncoder encoder(){
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        List<String> origin = new ArrayList<>();
	        origin.add("*");

	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(origin);
	        configuration.addAllowedHeader("*");
	        configuration.addAllowedMethod("*");
	        configuration.setAllowCredentials(true);
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
}