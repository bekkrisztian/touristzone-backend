package ro.touristzone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    AuthorizationServerConfig authorizationServerConfig;

    @Override
    public void configure(ResourceServerSecurityConfigurer config) throws Exception {
        config.tokenServices(authorizationServerConfig.tokenServices());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable().authorizeRequests()
                .antMatchers("/users/**", "/api/v1/auth/registration",
                		"/api/v1/countries/delete/{id}", "/api/v1/countries/save", "/api/v1/countries/save/{id}",
                		"/api/v1/counties/delete/{id}", "/api/v1/counties/save", "/api/v1/counties/save/{id}",
                		"/api/v1/images/save/{id}", "/api/v1/images/delete/{id}", 
                		"/api/v1/cover/save/{id}", "/api/v1/cover/delete/{id}", 
                		"/api/v1/flag/save/{id}", "/api/v1/flag/delete/{id}",
                		"/api/v1/opinions/delete/{id}", "/api/v1/opinions",
                		"/api/v1/pins/save", "/api/v1//pins/delete/{id}",
                		"/api/v1/sources/save", "/api/v1/sources/save/{id}", "/api/v1/source/save/{id}", "/api/v1/source/save", "/api/v1/sources/delete/{id}",
                		"/api/v1/others/save", "/api/v1/others/save/{id}", "/api/v1/other/save/{id}", "/api/v1/other/save", "/api/v1/others/delete/{id}",
                		"/api/v1/spectacles/save", "/api/v1/spectacles/save/{id}", "/api/v1/spectacles/delete/{id}")
                .access("hasRole('ROLE_ADMIN')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}