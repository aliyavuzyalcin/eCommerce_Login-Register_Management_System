package eCommerceLoginRegisterSystem.business.abstracts;

import eCommerceLoginRegisterSystem.entity.concrete.Member;

public interface MemberCheckService {
	
	boolean checkPassword(Member member);
	boolean checkName(Member member);
	boolean checkMail(Member member);

}
