package com.bangle.weather.Authentications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
        User user= userRepository.findByUsername(username);
        if (user==null) {
            throw new UsernameNotFoundException("Cannot find user: " + username);
        }
        List <Role> roles = roleRepository.findByUsename(username);
        return new UserPrincipal(user,roles);
    }
}
