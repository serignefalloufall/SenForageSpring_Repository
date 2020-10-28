package com.simplon.senForageSpringProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource; //ca va nous permet de pouvoir ecrir des req sql

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT email as principal, password as credentials,etat FROM user WHERE email = ?")
                .authoritiesByUsernameQuery("SELECT u.email as principal,r.nom as roles FROM user u, roles r, user_roles ur WHERE u.id = ur.users_id AND r.id = ur.roles_id AND u.email=?")
                .passwordEncoder(new BCryptPasswordEncoder())
                .rolePrefix("ROLE_");
    }//La methode configure permet de recuperer les infos de user conecte


    // configure les autorisations
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        try {
            http.formLogin().loginPage("/login");// http.formLogin() permet d'afficher la form de connexion par defaut
            //Definition des url en fonction des roles
            http.authorizeRequests().antMatchers("/Client/**").hasRole("USER");
            http.authorizeRequests().antMatchers("/Village/**").hasRole("USER");
            http.authorizeRequests().antMatchers("/User/**, /Roles/**").hasRole("SUPERADMIN");


            http.exceptionHandling().accessDeniedPage("/Admin/403");
            http.csrf().disable();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/assets/**" ,"/css/**", "/js/**", "/images/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}
