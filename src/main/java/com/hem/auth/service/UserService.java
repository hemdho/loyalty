package com.hem.auth.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hem.auth.dto.UserDto;
import com.hem.auth.model.PasswordResetToken;
import com.hem.auth.model.Role;
import com.hem.auth.model.User;
import com.hem.auth.model.VerificationToken;
import com.hem.auth.repository.RoleRepository;
import com.hem.auth.repository.UserRepository;
import com.hem.exception.RecordAlreadyExistException;
import com.hem.exception.RecordNotFoundException;
@Service
public class UserService implements IUserService{
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public static final String TOKEN_INVALID = "invalidToken";
	public static final String TOKEN_EXPIRED = "expired";
	public static final String TOKEN_VALID = "valid";
	
	
	@Override
	public User registerNewUserAccount(final UserDto accountDto) {
		if (emailExists(accountDto.getEmail())) {
			throw new RecordAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
		}
		final User user = new User();
		user.setFirstName(accountDto.getFirstName());
		user.setLastName(accountDto.getLastName());		
		if(accountDto.getPassword()==null) {
			accountDto.setPassword("1234@abcd");
		}
		user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
		//user.setPasswordExpiryDate(Utility.getNextPasswordExpiryDate());
		user.setEmail(accountDto.getEmail());
		user.setUsername(accountDto.getUsername());
		user.setEnabled(true);
	//	user.setIsUsing2FA(accountDto.isUsing2FA());
		user.setId(UUID.randomUUID().toString());
		Set<Role> roles=new HashSet<Role>();
		if(accountDto.getRoles()!=null&& accountDto.getRoles().size()>0) {
			accountDto.getRoles().forEach(role->{
				Role tempRole=null;
				Optional<Role> tempRoleOptional=null;
				if(role.getId()!=null) tempRoleOptional=roleRepository.findById(role.getId());
				else if(role.getName()!=null) tempRoleOptional=roleRepository.findByName(role.getId());
				if(tempRoleOptional.isPresent()) {
					tempRole=tempRoleOptional.get();
					roles.add(tempRole);
				}
			});
		}
		user.setRoles(roles);
		//user.setRoles(accountDto.getRoles())));
		user.setCreatedDate(new Date());
		return userRepository.save(user);
	}

	@Override
	public User getUserByVerificationToken(final String verificationToken) {

		final VerificationToken token = getVerificationToken(verificationToken);
		if (token != null) {
			return token.getUser();
		}

		return null;
	}

	@Override
	public VerificationToken getVerificationToken(final String VerificationToken) {
		return null;// tokenRepository.findByToken(VerificationToken);
	}

	 

	@Override
	public void deactivateUser(final User user) throws CloneNotSupportedException {
	    /* final VerificationToken verificationToken = tokenRepository.findByUser(user);
	        if (verificationToken != null) {
	            tokenRepository.delete(verificationToken);
	        }
	        final PasswordResetToken passwordToken = passwordTokenRepository.findByUser(user);
	        if (passwordToken != null) {
	            passwordTokenRepository.delete(passwordToken);
	        }*/
	        user.setEnabled(false);
	        userRepository.save(user);
	}

	@Override
	public void createVerificationTokenForUser(final User user, final String token) {
		final VerificationToken myToken = new VerificationToken(token, user);
		//tokenRepository.save(myToken);
	}

	@Override
	public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {

	/*	VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
		if (vToken != null) {
			vToken.updateToken(createToken());
			tokenRepository.save(vToken);
			return vToken;
		}*/

		return null;
	}

	@Override
	public void createPasswordResetTokenForUser(final User user, final String token) {
		//final PasswordResetToken myToken = new PasswordResetToken(token, user);
		//passwordTokenRepository.save(myToken);
	}

	@Override
	public User findUserByEmail(final String email) {
		User user= userRepository.findByEmail(email);
		//System.out.println("#######################User#################### "+user);
	//	if(Objects.nonNull(user)) user.setUserCompanies(userCompanyRepository.findByUser(user.getId()));
		
		//System.out.println("#######################User#################### "+user);
		return user;
	}

	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		return null;//passwordTokenRepository.findByToken(token);
	}

	@Override
	public User getUserByPasswordResetToken(final String token) {
		return null;//passwordTokenRepository.findByToken(token).getUser();
	}

	@Override
	public Optional<User> getUserByID(final String userId) {
		Optional<User> user= userRepository.findById(userId);
		return user;
	}

	@Override
	public User findUserByEmailOrId(String para) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailOrId(para);
	}
	@Override
	public void changeUserPassword(final User user, final String password) throws CloneNotSupportedException {
		user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
		
	/*	System.out.println("Password is " + password);
		PasswordResetToken passwordResetToken =passwordTokenRepository.findByUser(user);
		if(Objects.nonNull(passwordResetToken))
		passwordTokenRepository.delete(passwordResetToken);
	
		//tokenRepository.findByUser(user);
		
		tokenRepository.deleteAllByUser(user);*/
	}

	@Override
	public void changeUserEmail(final User user, final String newEmail) throws CloneNotSupportedException {
		
		userRepository.save(user);
	}

	@Override
	public User updateUser2FA(boolean use2FA) {
	/*	final Authentication curAuth = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = (User) curAuth.getPrincipal();
		currentUser.setUsing2FA(use2FA);
		userRepository.save(currentUser);
		final Authentication auth = new UsernamePasswordAuthenticationToken(currentUser, currentUser.getPassword(),
				curAuth.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
		return currentUser;*/
		return null;
	}

	@Override
	public boolean checkIfValidOldPassword(final User user, final String oldPassword) {
		return passwordEncoder.matches(oldPassword, user.getPassword());
	}

	@Override
	public String validateVerificationToken(String token) {
		/*final VerificationToken verificationToken = tokenRepository.findByToken(token);
		if (verificationToken == null) {
			return TOKEN_INVALID;
		}

		final Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			tokenRepository.delete(verificationToken);
			return TOKEN_EXPIRED;
		}*/

		return TOKEN_VALID;
	}

	@Override
	public String generateQRUrl(User user) throws UnsupportedEncodingException {
		return null;//QR_PREFIX + URLEncoder.encode(String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s", APP_NAME,
				//user.getEmail(), user.getSecretKey(), APP_NAME), "UTF-8");
	}

	@Override
	public User updateUser2FA(User user, boolean use2FA) throws CloneNotSupportedException {
		/*final User currentUser = (User) user.clone();
		currentUser.setIsUsing2FA(use2FA);
		userRepository.save(currentUser);
		user.setIsUsing2FA(use2FA);
		return user;*/
		return null;
	}

	private boolean emailExists(final String email) {
		return userRepository.findByEmail(email) != null;
	}

	@Override
	public List<String> getUsersFromSessionRegistry() {
		return null;

	}

	/***
	 * Generate token and return it
	 */
	public String createToken() {
		return UUID.randomUUID().toString();
	}

	/*@Override
	public Map<String, String> loginUser(String username, String password, DeviceMetadata deviceMetadata, Locale locale,
			String ip) throws IOException, GeoIp2Exception {
		com.ecompp.auth.model.User user = userRepository.findByEmail(username);
		if (user != null && passwordEncoder.matches(password, user.getPassword())) {

			deviceService.verifyDevice(user, deviceMetadata, locale, ip);
			String token = createToken();
			createVerificationTokenForUser(user, token);
			Map<String, String> map = new HashMap<String, String>();
			map.put("token", token);
			return map;
		} else {
			throw new BadCredentialsException("Invalid username or password");
		}

		return null;
	}
*/
	/***
	 * create a password reset token and send email to user
	 */
	@Override
	public String resetPassword(String userEmail, String appUrl, Locale locale) {
		System.out.println("user " + userEmail);
		final User user = findUserByEmail(userEmail);
		
		if (user == null) {
			throw new RecordNotFoundException("User not Found");
		}
		
		System.out.println("User Details : "+user);
		final String token = createToken();
		createPasswordResetTokenForUser(user, token);
		try {
			final SimpleMailMessage email = constructResetTokenEmail(appUrl, locale, token, user);
			//mailSender.send(email);
		} catch (final MailAuthenticationException e) {
			//LOGGER.debug("MailAuthenticationException", e);
			throw e;
		} catch (final Exception e) {
			throw e;
		}
		//return messages.getMessage("message.resetPasswordEmail", null, locale);
		return null;

	}

	
	private final SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale,final String token, final User user) {
		
		final String url = contextPath + "/user/changePassword.do?userId=" + user.getId() + "&token=" + token;
		final String message = "";//messages.getMessage("message.resetPassword", null, locale);
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("Reset Password");
		email.setText(message + " \r\n" + url);
	//	email.setFrom(env.getProperty("support.email"));
		return email;
	}

	

}
