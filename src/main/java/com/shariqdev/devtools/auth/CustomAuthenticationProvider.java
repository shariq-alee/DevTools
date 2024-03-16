package com.shariqdev.devtools.auth;

import com.shariqdev.devtools.model.User;
import com.shariqdev.devtools.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;

    public CustomAuthenticationProvider(UserService userDetailsService) {
        this.userService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userService.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        if (!password.equals(user.getPassword())) {
            throw new AuthenticationException("Invalid credentials") {
            };
        }

        Authentication authenticated = new UsernamePasswordAuthenticationToken(
                user, password);
        return authenticated;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
