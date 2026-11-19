package com.example.ssmdemo23.demos.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    // configure SecurityFilterChain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        // 放行登录页面
                        .requestMatchers("/login").permitAll()
                        // 拦截其他所有请求
                        .anyRequest().authenticated()
                )
                // 退出时，让session失效
                .logout(logout -> logout.invalidateHttpSession(true))
                // 配置登录页面 和 登录成功后页面
                .formLogin(form -> form.loginPage("/login").permitAll()
                        .loginProcessingUrl("/login").defaultSuccessUrl("/index"));
        // 开启csrf 保护
        http.csrf().disable();

        return http.build();
    }
}
