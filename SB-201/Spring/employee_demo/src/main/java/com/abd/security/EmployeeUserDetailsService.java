package com.abd.security;

import com.abd.model.Employee;
import com.abd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> opt = employeeRepository.findByEmail(username);
        if(opt.isPresent()){
            Employee emp = opt.get();
            List<GrantedAuthority> authorityList = new ArrayList<>();
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority(emp.getRole());
            authorityList.add(sga);
            return new User(emp.getEmail(), emp.getPassword(), authorityList);
        }
        else throw new BadCredentialsException("User not found with username: " + username);
    }
}
