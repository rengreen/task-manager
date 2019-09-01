package pl.rengreen.taskmanager.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SecurityConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder, DataSource dataSource) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery("select email as principal, password as credentials, true from user where email=?")
                .authoritiesByUsernameQuery("select u.email as principal, r.role as role from user u inner join user_role ur on(u.user_id=ur.user_id) inner join role r on(ur.role_id=r.role_id) where u.email=?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder)
                .rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register", "/", "/login", "/about", "/css/**", "/webjars/**")
                .permitAll()

                .antMatchers("/profile/**", "/tasks/**", "/task/**", "/users", "/user/**", "/h2-console/**")
                .hasAnyRole("USER, ADMIN")

                .antMatchers("/assignment/**")
                .hasAnyRole("ADMIN")

                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/profile")

                .and()
                .logout()
                .logoutSuccessUrl("/login");

        http.csrf().ignoringAntMatchers("/h2-console/**");
        http.headers().frameOptions().sameOrigin();
    }

}
