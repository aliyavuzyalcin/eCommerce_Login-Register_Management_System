package eCommerceLoginRegisterSystem.dataAccess.abstracts;

import java.util.List;

import eCommerceLoginRegisterSystem.entity.concrete.User;

public interface UserDao {
	
	void add(User user);
	void update(User user);
	void delete(User user);
	User getByEmail(String email);
	
	List<User> getAll();

}
