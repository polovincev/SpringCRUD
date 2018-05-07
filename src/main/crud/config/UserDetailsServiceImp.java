package main.crud.config;

import main.crud.model.User;
import main.crud.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Arrays;


@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final DBService dbService;

    @Autowired
    public UserDetailsServiceImp(DBService dbService) {
        this.dbService = dbService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = dbService.getUserLogin(username);

        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), Arrays.asList(authority));

        return userDetails;
    }

}
