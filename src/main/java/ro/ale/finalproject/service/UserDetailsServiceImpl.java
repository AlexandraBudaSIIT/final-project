package ro.ale.finalproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ale.finalproject.model.Role;
import ro.ale.finalproject.model.User;
import ro.ale.finalproject.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * UserDetailsServiceImpl class implement the UserDetailsService interface
 * to provide our own user service
 *
 * @author Alexandra Buda
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /**
     * Locates the user based on the username
     *
     * @param username the username identifying the user whose data is required
     * @return a fully populated user record
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        // throw if the user could not be found or the user has no GrantedAuthority
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRolename()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
