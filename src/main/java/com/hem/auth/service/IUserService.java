package com.hem.auth.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import com.hem.auth.dto.UserDto;
import com.hem.auth.model.PasswordResetToken;
import com.hem.auth.model.User;
import com.hem.auth.model.VerificationToken;

public interface IUserService {

	 User getUserByVerificationToken(String verificationToken);

	    User registerNewUserAccount(UserDto userdto);
	    void deactivateUser(User user) throws CloneNotSupportedException;
	    
	    //Map<String,String> loginUser(String username,String password,DeviceMetadata deviceMetadata,Locale locale,String ip) throws IOException, GeoIp2Exception;
	    
	    String createToken();
	    
	    String resetPassword(String userEmail, String appUrl, Locale locale);

	    void createVerificationTokenForUser(User user, String token);

	    VerificationToken getVerificationToken(String VerificationToken);

	    VerificationToken generateNewVerificationToken(String token);

	    void createPasswordResetTokenForUser(User user, String token);
	    

	    User findUserByEmail(String email);
	    
	    User findUserByUsername(String username);
	    
	    PasswordResetToken getPasswordResetToken(String token);

	    User getUserByPasswordResetToken(String token);

	    Optional<User> getUserByID(String  userId);

	    User findUserByEmailOrId(String para);
	    
	    void changeUserPassword(User user, String password) throws CloneNotSupportedException;

	    boolean checkIfValidOldPassword(User user, String password);

	    String validateVerificationToken(String token);

	    String generateQRUrl(User user) throws UnsupportedEncodingException;

	    User updateUser2FA(User user,boolean use2FA) throws CloneNotSupportedException;

	    List<String> getUsersFromSessionRegistry();

		void changeUserEmail(User user, String newEmail) throws CloneNotSupportedException;

		User updateUser2FA(boolean use2fa);
		
		 
}
