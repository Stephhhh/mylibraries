//package com.bnpparibas.itg.mylibraries.libraries.infrastructure;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//        securedEnabled = true,
//        jsr250Enabled = true,
//        prePostEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("toto")
//                    .password(passwordEncoder().encode("123"))
//                    .authorities("ROLE_USER")
//                    .and()
//                .withUser("admin")
//                    .password(passwordEncoder().encode("123"))
//                    .authorities("ROLE_ADMIN");
////        auth.jdbcAuthentication()
////                .usersByUsernameQuery("select username,password,enabled"
////                + "from users "
////                + "where username = ?")
////                .authoritiesByUsernameQuery("select username,authority "
////                        + "from authorities "
////                        + "where email = ?");
//        ;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                    .antMatchers("/securityNone").permitAll()
//                    .antMatchers("/login-url").permitAll()
//                    .antMatchers(
//                            "/", "/csrf",
//                            "/v2/api-docs",
//                            "/swagger-resources/**",
//                            "/swagger-ui.html",
//                            "/webjars/**"
//                    ).permitAll()
//                    .anyRequest().authenticated()
//                .and()
//
//                .formLogin()
//                    .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
//                        //do nothing
//                    })
//                .and()
//
//                .logout()
//                    .logoutUrl("/logout")
//                    .permitAll()
//
//                .and()
//
//                .exceptionHandling()
//                    .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                .and()
//
//                .csrf().disable();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
