package eCommerceLoginRegisterSystem.business.concrete;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceLoginRegisterSystem.business.abstracts.UserCheckService;
import eCommerceLoginRegisterSystem.core.abstracts.AuthenticationService;
import eCommerceLoginRegisterSystem.core.abstracts.EmailService;
import eCommerceLoginRegisterSystem.dataAccess.abstracts.UserDao;
import eCommerceLoginRegisterSystem.entity.concrete.User;

public class UserCheckManager implements UserCheckService{
	
	private AuthenticationService authService;
	private EmailService mailService;
	
	public UserCheckManager( EmailService mailService) {
		this.mailService = mailService;
	}

	public UserCheckManager(AuthenticationService authService, EmailService mailService) {
		super();
		this.authService = authService;
		this.mailService = mailService;
	}

	@Override
	public boolean isValidFirstName(String firstName) {
		if(!(firstName.isEmpty()) && firstName.length() >= 2) {
			
			return true;			
		}else {
			System.out.println("Name cannot be less than 2 character");
			return false;
		}
	}

	@Override
	public boolean isValidLastName(String lastName) {
		if(!(lastName.isEmpty()) && lastName.length() >= 2) {
			return true;
		}else {
			System.out.println("Surname cannot be less than 2 character");
			return false;
		}
	}

	@Override
	public boolean isValidEmailFormat(String email) {
		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		 
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(email);
			
		if(!(pattern.matcher(email).matches()) && email.isEmpty()) {
			System.out.println("Wrong email format");
			return false;
		}else {
			
			return true;
		}
		
	}

	@Override
	public boolean isValidPassword(String password) {
		
		if(password.length() < 6 && password.isBlank()) {
			
			System.out.println("Password must be more than 6 characters");
			
			return false;
		}else {
			
			return true;
		}
	}

	@Override
	public boolean isUsedEmail(String email, UserDao userDao) {
		
		if(userDao.getByEmail(email) != null) {
			System.out.println("This email is not available!");
			
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean isValidUser(User user, UserDao userDao) {
		
		if(authService != null) {
			
			return authService.isValidUser();
		}else if(!(isValidFirstName(user.getFirstName()))) {
			return false;
		}else if(!(isValidLastName(user.getLastName()))) {
			return false;
		}else if(!(isValidPassword(user.getPassword()))) {
			return false;
		}else if(isUsedEmail(user.getMail(), userDao)){
			return false;
		}else{
			mailService.sendVerificationLink(user.getMail());
			System.out.println("Verified!");
			return true;
		}
	}

	@Override
	public boolean isCorrectLoginInput(String email, String password, UserDao userDao) {
		
		if(authService != null) {
			return authService.isValidUser();
		}
		User user = userDao.getByEmail(email);
		
		if(user == null && !(user.getPassword().equals(password))) {
			System.out.println("Incorrect email or password!");
			return false;
		}else {
			System.out.println("Logged in successfully!");
			return true;
		}
		
	}

}
