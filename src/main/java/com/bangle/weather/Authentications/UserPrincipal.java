package com.bangle.weather.Authentications;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserPrincipal implements UserDetails {
    private User user;
    private List <Role> roles;

    public UserPrincipal ( User user, List<Role> roles) {
        this.user = user;
        this.roles = roles;
    }

    @Override
    public Collection < ? extends GrantedAuthority > getAuthorities ( ) {
        if (roles==null) {
            return Collections.emptySet();
        }
        Set <SimpleGrantedAuthority> authoritySet = new HashSet<>();
        roles.forEach(role->authoritySet.add(new SimpleGrantedAuthority(role.getRole())));
        return authoritySet;
    }

    @Override
    public String getPassword ( ) {
        return this.user.getPassword();
    }

    @Override
    public String getUsername ( ) {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired ( ) {
        return true;
    }

    @Override
    public boolean isAccountNonLocked ( ) {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired ( ) {
        return true;
    }

    @Override
    public boolean isEnabled ( ) {
        return true;
    }
}
