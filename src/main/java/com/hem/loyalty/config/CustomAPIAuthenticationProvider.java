package com.hem.loyalty.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.hem.auth.model.Role;

import com.hem.auth.service.IUserService;

import com.hem.common.util.Privilege;

public class CustomAPIAuthenticationProvider  extends AbstractUserDetailsAuthenticationProvider { 

	@Autowired
 IUserService userService;

	

	@Override
	protected UserDetails retrieveUser(String userName,
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
		try {
			
					Object creds = usernamePasswordAuthenticationToken.getCredentials();
					com.hem.auth.model.User tempUser = userService.getUserByID(userName).get();
					List<GrantedAuthority> authorities =new ArrayList<GrantedAuthority>();
					authorities.add(new SimpleGrantedAuthority("ROLE"));
					User user = new User(userName, tempUser.getPassword(), authorities);
					return user;
		}catch(Exception e) {
			throw new BadCredentialsException("Invalid credentials!!");
		/*if (creds != null && String.class.isAssignableFrom(creds.getClass())) {
			String token = (String) creds;
			com.hem.auth.model.User tempUser = userService.getUserByVerificationToken(token);
			if (Objects.nonNull(tempUser)) {
				String validToken = userService.validateVerificationToken(token);
				boolean enabled = tempUser.isEnabled(), accountNonExpired = true, credentialsNonExpired = true,
						accountNonLocked = true;
				if(!validToken.equalsIgnoreCase(UserService.TOKEN_VALID)) {
					throw new BadCredentialsException("Invalid credentials");
				}
				//tempUser =userService.findUserByEmail(tempUser.getEmail()); 
				List<GrantedAuthority> authorities =new ArrayList<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority("ROLE"));
				//(List<GrantedAuthority>) getAuthorities1(tempUser.getRoles());
				User user = new User(userName, tempUser.getPassword(), authorities);
				//enabled, accountNonExpired,
					//	credentialsNonExpired, accountNonLocked, authorities);
				return user;
			}*/

			
		}
		
	}
	
	private final Collection<? extends GrantedAuthority> getAuthorities1(final Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }
	private final List<Short> getPrivileges(final Collection<Role> roles) {
        final List<Short> privileges = new ArrayList<Short>();
        final List<Short> collection = new ArrayList<Short>();
        for (final Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (final Short item : collection) {
            privileges.add(item);
        }

        return privileges;
    }

	private final List<Short> toPrivileges(final Collection<Short> collection) {
		final List<Short> privileges = new ArrayList<Short>();
		for (final Short item : collection) {
			privileges.add(item);
		}

		return privileges;
	}

	private final List<GrantedAuthority> getGrantedAuthorities(final List<Short> privileges) {
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (final Short privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(String.valueOf(privilege)));
		}
		return authorities;
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}
}
