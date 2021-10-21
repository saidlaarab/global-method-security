package spring.security.globalmethodsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();

        UserDetails saidUser = User.withUsername("said")
                .password("said123")
                .authorities("ROLE_admin") // <=> roles("admin")
                .build();

        UserDetails medUser = User.withUsername("med")
                .password("med123")
                .authorities("read")
                .build();

        userDetailsService.createUser(saidUser);
        userDetailsService.createUser(medUser);

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
