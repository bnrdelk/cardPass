package com.ash.springbootpersonelbilgisistemi.security.jwt;

import com.ash.springbootpersonelbilgisistemi.security.UserPrincipal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface IJwtProvider
{
    String generateToken(UserPrincipal auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean validateToken(HttpServletRequest request);
}