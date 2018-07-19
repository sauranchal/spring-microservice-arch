package com.pkg.spring.config.configserver.com.pkg.spring.config.security;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by sdixit9 on 7/17/2018.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("#{'${qa.admin.password:admin}'}") //property with default value
            String admin_password;

    @Value("#{'${qa.user.password:user}'}") //property with default value
            String user_password;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password(user_password).roles("USER")
                .and()
                .withUser("admin").password(admin_password).roles("USER", "ACTUATOR");
    }


    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/encrypt/**").authenticated()
                .antMatchers("/decrypt/**").authenticated()
        //.antMatchers("/admin/**").hasAuthority("ROLE_ACTUATOR")
        //.antMatchers("/qa/**").permitAll()

        ;
    }

}
