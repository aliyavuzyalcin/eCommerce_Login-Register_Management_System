package eCommerceLoginRegisterSystem.business.concrete;

import eCommerceLoginRegisterSystem.business.abstracts.MembershipService;
import eCommerceLoginRegisterSystem.entity.concrete.Member;

public class MembershipManager implements MembershipService{

	MemberCheckManager memberCheckManager = new MemberCheckManager();

	
	public MembershipManager(MemberCheckManager memberCheckManager) {
		super();
		this.memberCheckManager = memberCheckManager;
	}

	@Override
	public void add(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInfo(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Member member) {
		// TODO Auto-generated method stub
		
	}

}
