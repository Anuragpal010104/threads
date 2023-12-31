package com.projx.blogapplication.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projx.blogapplication.models.AppUser;
import com.projx.blogapplication.models.entities.User;
import com.projx.blogapplication.repositories.interfaces.UserRepository;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Fetching user with {}", username);
        User user = userRepository.findUserByUsernameIgnoreCaseOrEmailIgnoreCase(username.toLowerCase())
                .orElseThrow(
                        () -> new UsernameNotFoundException("Invalid username/email or password")
                );
        return new AppUser(user);
    }
}
