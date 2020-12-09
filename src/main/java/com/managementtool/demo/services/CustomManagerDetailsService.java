package com.managementtool.demo.services;

import com.managementtool.demo.models.Manager;
import com.managementtool.demo.repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CustomManagerDetailsService implements UserDetailsService {
    @Autowired
    ManagerRepo managerRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Manager manager = managerRepo.findByEmail(email);
        if (manager == null) {
            throw new UsernameNotFoundException(email);
        }
        UserDetails user = User.withUsername(manager.getEmail()).password(manager.getPassword()).authorities("MANAGER").build();
        return user;
    }
}
