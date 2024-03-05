package com.sanctityofthelord.souldashboard.config;


import com.sanctityofthelord.souldashboard.web.LoggingAccessDeniedHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.File;
import java.util.List;


@Configuration
@EnableWebSecurity
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private ApplicationProperties appUserProperties;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(
                            "/contact/**",
                            "/js/**",
                            "/css/**",
                            "/fronts/**",
                            "/img/**",
                            "/bundles/**")
                .permitAll()
                    .antMatchers("/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                    .antMatchers("/user/**").hasAnyAuthority("ROLE_USER")
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
                .and()
                .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler);
    }

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {

        List<AppUser> appUserList = appUserProperties.getAppUserList();

        for (AppUser appUser : appUserList) {
            auth
                .inMemoryAuthentication()
                .withUser(appUser.getUserName())
                .password(appUser.getPassword())
                .roles(appUser.getRole());
        }
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
                new PropertySourcesPlaceholderConfigurer();
        String filePath = System.getProperty("user.dir") + File.separator + "file-properties" + File.separator + "application-dev.yml";
        log.info("chemin du fichier de propriete " +filePath);
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new FileSystemResource(filePath));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
        return propertySourcesPlaceholderConfigurer;
    }

}
