package eCommerceLoginRegisterSystem.business.concrete;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



import eCommerceLoginRegisterSystem.business.abstracts.MemberCheckService;
import eCommerceLoginRegisterSystem.entity.concrete.Member;


public class MemberCheckManager implements MemberCheckService{

	@Override
	public boolean checkPassword(Member member) {
		boolean flag = false;
		try {
			if(member.getPassword().length() >= 6) {
				
				flag = true;
			}else {
				
				flag = false;
			}
		} catch (NullPointerException e) {
			e.getMessage();
		}
		return flag;
	}

	@Override
	public boolean checkName(Member member) {
		boolean flag = false;
		try {
			if(!(member.getFirstName().isEmpty()) && !(member.getFirstName().isEmpty())) {
				
				flag = true;
			}else {
				
				flag = false;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean checkMail(Member member) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		 
		Pattern pattern = Pattern.compile(regex);
		
		String email = member.getMail();
			
		Matcher matcher = pattern.matcher(email);
			
		if(matcher.matches() == true) {
			
			return true;
		}else {
			
			new Throwable(email);
			return false;
		}
		
	
	}

}
