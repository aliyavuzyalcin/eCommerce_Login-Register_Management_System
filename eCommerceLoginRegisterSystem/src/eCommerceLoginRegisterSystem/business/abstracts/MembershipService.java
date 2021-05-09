package eCommerceLoginRegisterSystem.business.abstracts;

import eCommerceLoginRegisterSystem.entity.concrete.Member;

public interface MembershipService {
	
	void add(Member member);
	
	void updateInfo(Member member);
	
	void delete(Member member);
	

}
