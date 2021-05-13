package com.example.demo.httpsessionService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collection;

@Service
public class SessionService {

    public String  getCurrentUserName(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    public Collection<? extends GrantedAuthority> getCurrentUserAuthentication(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities();
    }
    public boolean getUserState(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.isAuthenticated();
    }
}
