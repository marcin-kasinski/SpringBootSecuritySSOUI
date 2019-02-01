package org.baeldung.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableOAuth2Sso
@Configuration
public class UiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
        //.csrf().disable()
        
        //.formLogin()
        //.loginPage("/login")
        //.permitAll()
        //.and()
        //.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        //.logoutUrl("/logout")
        //.logoutSuccessUrl("/login")
        //.invalidateHttpSession(true)
        //.deleteCookies("JSESSIONID")
        
        //.and()
        
        
        .antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/", "/login**")
            .permitAll()
            .anyRequest()
            .authenticated()
            //.and().logout().logoutSuccessUrl("/").invalidateHttpSession(true).deleteCookies("refreshToken","auth_code","JSESSIONID")
            .and().logout().invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutSuccessUrl("http://localhost:8081/auth/logout")
            .and().exceptionHandling().accessDeniedPage("/accessdenied")
            //.deleteCookies("JSESSIONID", "XSRF-TOKEN","jweToken").permitAll().and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
            //.permitAll()
            ;
        
    }

}
