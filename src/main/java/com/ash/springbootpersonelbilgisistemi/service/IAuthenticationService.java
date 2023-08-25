package com.ash.springbootpersonelbilgisistemi.service;

import com.ash.springbootpersonelbilgisistemi.model.Employee;

public interface IAuthenticationService {

    Employee signInAndReturnJWT(Employee signInRequest);
}
