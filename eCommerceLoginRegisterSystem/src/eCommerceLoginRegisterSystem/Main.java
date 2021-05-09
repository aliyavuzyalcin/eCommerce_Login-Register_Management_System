package eCommerceLoginRegisterSystem;

import eCommerceLoginRegisterSystem.business.concrete.UserCheckManager;
import eCommerceLoginRegisterSystem.business.concrete.UserManager;
import eCommerceLoginRegisterSystem.core.concrete.EmailManager;
import eCommerceLoginRegisterSystem.core.concrete.GoogleAuthAdapter;
import eCommerceLoginRegisterSystem.dataAccess.concrete.HibernateUserDao;
import eCommerceLoginRegisterSystem.entity.concrete.User;

public class Main {

	public static void main(String[] args) {
			
		
		User user1 = new User("Ali Yavuz","Yalçýn","aliyavuzyalcin@gmail.com","test12345");
		
		User user2 = new User("Engin", "Demirog", "enginDemirog*@gmail. com.", "");
		
		User user3 = new User();
		
		
		UserManager userManager1 = new UserManager(new HibernateUserDao(), new UserCheckManager(new EmailManager()));
		userManager1.register(user1);
		//userManager1.register(user2);
		
		userManager1.login(user1.getMail(), user1.getPassword());
		//userManager1.login(user2.getMail(), user2.getPassword());
		
		userManager1.update(user1);
		
		//userManager1.delete(user2);
		
		UserManager userManager2 = new UserManager(new HibernateUserDao(), new UserCheckManager(new GoogleAuthAdapter(), new EmailManager()));
		
		userManager2.register(user3);
		userManager2.login(user3.getMail(), user3.getPassword());
		

	}

}
