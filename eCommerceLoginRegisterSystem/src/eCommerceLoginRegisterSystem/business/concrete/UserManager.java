package eCommerceLoginRegisterSystem.business.concrete;

import eCommerceLoginRegisterSystem.business.abstracts.UserCheckService;
import eCommerceLoginRegisterSystem.business.abstracts.UserService;
import eCommerceLoginRegisterSystem.dataAccess.abstracts.UserDao;
import eCommerceLoginRegisterSystem.entity.concrete.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private UserCheckService checkService;

	
	public UserManager(UserDao userDao, UserCheckService checkService) {
		super();
		this.userDao = userDao;
		this.checkService = checkService;
	}

	@Override
	public void register(User user) {
		
		if(checkService.isValidUser(user, userDao)) {
			userDao.add(user);
			System.out.println("Registration is successfull!");
			return;
		}else {
			System.out.println("Registration is failed! Check if user is valid!");
		}		
	}

	@Override
	public void update(User user) {
		
		if(checkService.isValidUser(user, userDao)) {
			userDao.update(user);
			System.out.println("Update is successfull!");
			return;
		}else {
			System.out.println("Update is failed! Check if user is valid!");
		}		
		
	}

	@Override
	public void delete(User user) {
		
		if(checkService.isValidUser(user, userDao)) {
			userDao.getByEmail(user.getMail());
			userDao.delete(user);
			System.out.println("User deleted successfully!");
			return;
		}else {
			System.out.println("Deletion is failed! Check if user is valid!");
		}	
		
	}

	@Override
	public void login(String email, String password) {
		
		if(checkService.isCorrectLoginInput(email, password, userDao)) {
			System.out.println("Logged in...");
			return;
		}else {
			System.out.println("Loggin failed!");
		}
		
		
	}

}
