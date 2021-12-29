package com.pajak.training.auth;

import com.pajak.training.entity.User;
import com.pajak.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        return new ApplicationUser(username, user.getPassword(),
                Set.of(new SimpleGrantedAuthority("ROLE_ADMIN")),
                true,
                true,
                true,
                true);
    }
}
