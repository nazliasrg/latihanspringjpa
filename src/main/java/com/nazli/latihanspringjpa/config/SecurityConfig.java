package com.nazli.latihanspringjpa.config;

import com.nazli.latihanspringjpa.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserServiceImp userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests().antMatchers("/").permitAll()
//                semua yang url ada user nya tidak harus login dulu
                .antMatchers(HttpMethod.POST, "/api/v1/user/**").permitAll()
//                tidak harus login terlebih dahulu maka bisa kodingan ini
                .antMatchers(HttpMethod.GET, "api/v1/pendidikan-all").permitAll()
//                selain 2 line diatas, harus login dulu untuk ke halamannya, kalau mau diakses harus pake token
                .anyRequest().fullyAuthenticated().and().httpBasic().and().csrf().disable();

        http.addFilterBefore(new CorsConfig(), ChannelProcessingFilter.class);
    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
