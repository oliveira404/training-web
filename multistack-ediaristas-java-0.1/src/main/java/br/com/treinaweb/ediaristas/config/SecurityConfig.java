package br.com.treinaweb.ediaristas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import br.com.treinaweb.ediaristas.core.enums.TipoUsuario;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${br.com.treinaweb.ediaristas.rememberMe.key}")
    private String rememberMeKey;

    @Value("${br.com.treinaweb.ediaristas.rememberMe.validitySeconds}")
    private Integer rememberMeValiditySeconds;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/**")
                .permitAll()
                .antMatchers("/admin/**").hasAuthority(TipoUsuario.ADMIN.toString())
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/admin/login")
                .usernameParameter("email")
                .passwordParameter("senha")
                .defaultSuccessUrl("/admin/servicos")
                .permitAll();

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout", "GET"))
                .logoutSuccessUrl("/admin/login");

        // 48h *60m *60s
        http.rememberMe()
                .rememberMeParameter("lembrar-me")
                .tokenValiditySeconds(rememberMeValiditySeconds)
                .key(rememberMeKey);

        http.cors();

        http.csrf().ignoringAntMatchers("/api/**");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**");

        web.ignoring().antMatchers(
                "/swagger-ui/**", "/v3/api-docs/**");
    }
        
        /*web.ignoring().antMatchers(
        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/swagger-ui.html**",
                        "/webjars/**",
                        "/favicon.ico",
                        "/favicon.ico**",
                        "/swagger-ui/#**",
                        "/swagger-ui/#",
                        "/swagger-ui/**",
                        "/swagger-ui/",
                        "/swagger-ui**");
    }*/
}
