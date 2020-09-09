package com.bnpparibas.itg.mylibraries.libraries.infrastructure;

import com.bnpparibas.itg.mylibraries.libraries.infrastructure.users.Users;
import com.bnpparibas.itg.mylibraries.libraries.infrastructure.users.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import javax.sql.DataSource;
import java.util.Arrays;

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

//        Pour une liste d'utilisateurs en mémoire (e.g : pour faire des tests)

//        auth.inMemoryAuthentication()
//                .withUser("toto")
//                    .password(passwordEncoder().encode("123"))
//                    .roles("TOTO") //Il faut choisir soit roles (et il ajoute automatiquemenr "ROLE_" ou authorities
//                .and()
//                .withUser("admin")
//                    .password(passwordEncoder().encode("123"))
//                    .authorities("ROLE_USER", "ROLE_ADMIN");

//      Pour aller chercher les utilisateurs en base
//      Les deux lignes ci-dessous sont uniquement là pour créer des utilisateurs au démarrage de l'application
//      Dans une "réelle" application les utilisateurs sont déjà présents en base (ou créés via un service d'inscription par exemple)
        userDAO.save(new Users("user", passwordEncoder().encode("123"), true, Arrays.asList("ROLE_USER")));
        userDAO.save(new Users("admin", passwordEncoder().encode("123"), true, Arrays.asList("ROLE_ADMIN")));

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, active "
                        + "from users "
                        + "where username = ?")
                .authoritiesByUsernameQuery("select users_username, roles "
                        + "from users_roles "
                        + "where users_username = ?");

//      Pour aller chercher les utilisateurs de manière personnalisée (ni mémoire, ni LDAP, ni JDBC etc... - e.g : service externe)
//      auth.userDetailsService(userDS);
    }

//    @Autowired
//    MyUserDetailsService userDS;

    @Autowired
    DataSource dataSource;

    @Autowired
    UsersDAO userDAO;

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
                .antMatchers( "/h2-console/**").permitAll()
                .antMatchers( "/**.css").permitAll()
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
                    httpServletResponse.getWriter().println("Autentification effectuée !");})
            .and()

            .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.getWriter().println("Logout effectué !");
                })
            .and()

            .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            .and()

            .csrf().disable()

            .headers().frameOptions().disable(); //for H2-console
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
