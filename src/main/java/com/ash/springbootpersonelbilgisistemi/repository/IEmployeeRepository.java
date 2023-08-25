package com.ash.springbootpersonelbilgisistemi.repository;

import com.ash.springbootpersonelbilgisistemi.model.Employee;
import com.ash.springbootpersonelbilgisistemi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findByName(String name);

    Optional<Employee> findByMail(String mail);

    @Modifying
    @Query("update Employee set role = :role where mail = :mail")
    void updateEmployeeRole(@Param("mail") String mail, @Param("role") Role role);

    @Modifying
    @Query("update Employee set name = :name where mail = :mail ")
    void updateEmployeeName(@Param("mail") String mail, @Param("name") String name);
}
