package com.pajak.training.auth;

import com.pajak.training.entity.User;
import com.pajak.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        // transform Set<UserAuthority> ====> Set<SimpleGrantedAuthority>
        Set<SimpleGrantedAuthority> userAuthorities = user.getAuthorities().stream()
                .map(userAuthority -> new SimpleGrantedAuthority(userAuthority.getAuthority()))
                .collect(Collectors.toSet());

        return new ApplicationUser(username, user.getPassword(),
                userAuthorities,
                true,
                true,
                true,
                true);
    }
}
