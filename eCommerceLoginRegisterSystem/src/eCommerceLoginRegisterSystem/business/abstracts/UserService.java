package eCommerceLoginRegisterSystem.business.abstracts;

import eCommerceLoginRegisterSystem.entity.concrete.User;

public interface UserService {
	
	void register(User user);
	void update(User user);
	void delete (User user);
	void login(String email, String password);

}
