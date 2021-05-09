package eCommerceLoginRegisterSystem.core.concrete;

import eCommerceLoginRegisterSystem.core.abstracts.AuthenticationService;
import eCommerceLoginRegisterSystem.googleAuthentication.GoogleAuthManager;

public class GoogleAuthAdapter implements AuthenticationService {

	@Override
	public boolean isValidUser() {
		
		return new GoogleAuthManager().isValidUserByGoogle();
	}
	
	

}
