package eCommerceLoginRegisterSystem.core.concrete;

import eCommerceLoginRegisterSystem.core.abstracts.EmailService;

public class EmailManager implements EmailService{

	@Override
	public void sendVerificationLink(String message) {
		System.out.println("Verification link is sent to " + message);
		System.out.println("Verification link ---> www.thisisanactivationlink.com");
		
	}

}
