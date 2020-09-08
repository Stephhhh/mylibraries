package com.bnpparibas.itg.mylibraries.libraries.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Profile("!dev")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,  //@Secured("ROLE_ADMIN")
        jsr250Enabled = true,   //@RolesAllowed("ADMIN")
        prePostEnabled = true)
public class SecuConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("toto")
                    .password(passwordEncoder().encode("123"))
                    .roles("TOTO") //Il faut choisir soit roles (et il ajoute automatiquemenr "ROLE_" ou authorities
                .and()
                .withUser("admin")
                    .password(passwordEncoder().encode("123"))
                    .authorities("ROLE_USER", "ROLE_ADMIN");

//        auth.jdbcAuthentication()
//                .usersByUsernameQuery("select username,password,enabled"
//                + "from users "
//                + "where username = ?")
//                .authoritiesByUsernameQuery("select username,authority "
//                        + "from authorities "
//                        + "where email = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //bloc de builder relatif à l'autorisation des requêtes
            .authorizeRequests()
                // '/**' signifie 'la racine et toute l'arborescence qui suit'
                .antMatchers("/unsecured/**").permitAll()
                .antMatchers("/login").permitAll()
                // Ici la même url peut avoir des accès différents selon les verbes HTTP utilisés
                .antMatchers(HttpMethod.GET, "/url").permitAll()
                .antMatchers(HttpMethod.POST, "/url").authenticated()
                .antMatchers(
                        "/", "/csrf",
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**"
                ).permitAll()
                .anyRequest().authenticated()
            .and()

//            .httpBasic()
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.getWriter().println("Autentification effectuée !");
                })
            .and()

            .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.getWriter().println("Logout effectuée !");
                })
            .and()

            .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            .and()

            .csrf().disable()
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
