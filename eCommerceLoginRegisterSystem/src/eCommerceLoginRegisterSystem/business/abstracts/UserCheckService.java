package eCommerceLoginRegisterSystem.business.abstracts;

import eCommerceLoginRegisterSystem.dataAccess.abstracts.UserDao;
import eCommerceLoginRegisterSystem.entity.concrete.User;

public interface UserCheckService {
	
	boolean isValidFirstName(String firstName);
	boolean isValidLastName(String lastName);
	boolean isValidEmailFormat(String email);
	boolean isValidPassword(String password);
	boolean isUsedEmail(String email, UserDao userDao);
	boolean isValidUser(User user, UserDao userDao);
	boolean isCorrectLoginInput(String email, String password, UserDao userDao);
	

}
