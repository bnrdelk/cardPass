package com.ash.springbootpersonelbilgisistemi.security;

import com.ash.springbootpersonelbilgisistemi.model.Employee;
import com.ash.springbootpersonelbilgisistemi.service.IEmployeeService;
import com.ash.springbootpersonelbilgisistemi.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private IEmployeeService userService;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException
    {
        Employee employee = userService.findByMail(mail)
                .orElseThrow(() -> new UsernameNotFoundException(mail));

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(employee.getRole().name()));

        return UserPrincipal.builder()
                .employee(employee).id(employee.getId())
                .mail(mail)
                .password(employee.getPassword())
                .authorities(authorities)
                .build();
    }
}