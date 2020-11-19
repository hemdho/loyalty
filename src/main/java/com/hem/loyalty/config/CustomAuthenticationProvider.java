package com.hem.loyalty.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hem.auth.model.User;
import com.hem.auth.service.IUserService;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {
	    private IUserService userService;
	 PasswordEncoder passwordEncoder;
	 
	 public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	    public Authentication authenticate(Authentication auth) throws AuthenticationException {
	    	final User user = userService.findUserByEmail(auth.getName());
	        if ((user == null)) {
	            throw new BadCredentialsException("Invalid username or password");
	        }
	        if (user != null && !passwordEncoder.matches(auth.getCredentials().toString(), user.getPassword())) {
	            throw new BadCredentialsException("Invalid username or password");
	        }
	        // to verify verification code
	       /* if (user.isIsUsing2FA()) {
	            final String verificationCode = ((CustomWebAuthenticationDetails) auth.getDetails()).getVerificationCode();
	            final Totp totp = new Totp(user.getSecretKey());
	            if (!isValidLong(verificationCode) || !totp.verify(verificationCode)) {
	                throw new BadCredentialsException("Invalid verfication code");
	            }

	        }*/
	       // user.getRoles();
	        final Authentication result = super.authenticate(auth);
	        return new UsernamePasswordAuthenticationToken(user, result.getCredentials(), result.getAuthorities());
	    }

}
