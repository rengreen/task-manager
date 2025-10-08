package pl.rengreen.taskmanager.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final DataSource dataSource;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Bean
//    public SecurityFilterChain configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.
//                jdbcAuthentication()
//                .usersByUsernameQuery("select email as principal, password as credentials, true from user where email=?")
//                .authoritiesByUsernameQuery("select u.email as principal, r.role as role from user u inner join user_role ur on(u.user_id=ur.user_id) inner join role r on(ur.role_id=r.role_id) where u.email=?")
//                .dataSource(dataSource)
//                .passwordEncoder(bCryptPasswordEncoder)
//                .rolePrefix("ROLE_");
//    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((req) -> req
                                .requestMatchers("/register", "/", "/login", "/about", "/css/**", "/webjars/**")
                .permitAll()
                                .requestMatchers("/profile/**", "/tasks/**", "/task/**", "/users", "/user/**", "/h2-console/**")
                .hasAnyRole("USER, ADMIN")
                                .requestMatchers("/assignment/**")
                .hasAnyRole("ADMIN")
                )

                .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/profile")
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/login"));

        http.csrf().ignoringRequestMatchers("/h2-console/**");
        http.headers().frameOptions().sameOrigin();
        return http.build();
    }

}
