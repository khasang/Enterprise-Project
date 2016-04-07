package io.khasang.enterprise.service;

import io.khasang.enterprise.dao.interfaces.ClientDao;
import io.khasang.enterprise.dao.interfaces.EmployeeDao;
import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.model.ClientRole;
import io.khasang.enterprise.model.Employee;
import io.khasang.enterprise.model.EmployeeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        Client client = clientDao.findByLogin(login);
        if(client != null) {
            List<GrantedAuthority> authorities = buildClientAuthority(client.getClientRoles());
            return buildUserFormClient(client, authorities);
        } else {
            Employee employee = employeeDao.findByLogin(login);
            if(employee != null) {
                List<GrantedAuthority> authorities = buildEmployeeAuthority(employee.getEmployeeRoles());
                return buildUserFormEmployee(employee, authorities);
            }
            return null;
        }
    }

    private User buildUserFormClient(Client client, List<GrantedAuthority> authorities) {
        return new User(client.getLogin(), client.getPassword(),
                client.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildClientAuthority(Set<ClientRole> roles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        for (ClientRole clientRole : roles) {
            setAuths.add(new SimpleGrantedAuthority(clientRole.getRole()));
        }
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
        return result;
    }

    private User buildUserFormEmployee(Employee employee, List<GrantedAuthority> authorities) {
        return new User(employee.getLogin(), employee.getPassword(),
                employee.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildEmployeeAuthority(Set<EmployeeRole> roles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        for (EmployeeRole employeeRole : roles) {
            setAuths.add(new SimpleGrantedAuthority(employeeRole.getRole()));
        }
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
        return result;
    }
}
