package com.ash.springbootpersonelbilgisistemi.service;

import com.ash.springbootpersonelbilgisistemi.model.Employee;
import com.ash.springbootpersonelbilgisistemi.security.UserPrincipal;
import com.ash.springbootpersonelbilgisistemi.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
@Service
public class AuthenticationService implements IAuthenticationService
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IJwtProvider jwtProvider;

    @Override
    public Employee signInAndReturnJWT(Employee signInRequest)
    {
        System.out.println(signInRequest.getMail() + ", " + signInRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getMail(), signInRequest.getPassword())
        );

        System.out.println(signInRequest.getMail() + ", " + signInRequest.getPassword());
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        Employee signInUser = userPrincipal.getEmployee();
        signInUser.setToken(jwt);

        return signInUser;
    }
}