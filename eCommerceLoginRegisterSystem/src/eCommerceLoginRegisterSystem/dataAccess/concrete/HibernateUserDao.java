package eCommerceLoginRegisterSystem.dataAccess.concrete;

import java.util.ArrayList;
import java.util.List;

import eCommerceLoginRegisterSystem.dataAccess.abstracts.UserDao;
import eCommerceLoginRegisterSystem.entity.concrete.User;

public class HibernateUserDao implements UserDao{

	List<User>usersInDatabase = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		
		System.out.println("Saved to database by Hibernate : " + user.getMail());
		
		usersInDatabase.add(user);
	}

	@Override
	public void update(User user) {
		
		System.out.println("Updated succesfully! User : " + user.getMail());
		
		usersInDatabase.remove(getByEmail(user.getMail()));
		usersInDatabase.add(user);
		
	}

	@Override
	public void delete(User user) {
		
		System.out.println("User deleted from database ! : " + user.getMail());
		
		usersInDatabase.remove(getByEmail(user.getMail()));
		
	}

	@Override
	public User getByEmail(String email) {
		
		List<User> users = getAll();
		
		if(users != null) {
			
			for(User user : users) {
				
				if(user.getMail().equals(email)) {
					
					return user;
				}
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return usersInDatabase;
	}

}
