package com.hem.auth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hem.auth.model.Privilege;
import com.hem.auth.model.Role;
import com.hem.auth.model.User;
import com.hem.auth.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	
	

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		 return new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(), user.isEnabled(), true, true, true, getAuthorities(user.getRoles()));
		//return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, getAuthorities(null));
	}

	private final Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }
	
	  private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
	        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        for (final String privilege : privileges) {
	            authorities.add(new SimpleGrantedAuthority(privilege));
	        }
	        return authorities;
	    }
	
	private final List<String> getPrivileges(final Collection<Role> roles) {
        final List<String> privileges = new ArrayList<String>();
        final List<Short> collection = new ArrayList<Short>();
        for (final Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (final Short item : collection) {
            privileges.add(String.valueOf(item));
        }

        return privileges;
    }
	
}
	