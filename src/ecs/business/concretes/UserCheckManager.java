package ecs.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ecs.business.abstracts.UserCheckService;
import ecs.entities.concretes.User;

public class UserCheckManager implements UserCheckService{

	@Override
	public boolean checkFirstName(String firstName) {//isim en az 2 harf-karakter olacak
		
		if (firstName.length() < 2) {
			System.out.println("İsim 2 karakterden az olamaz!");
			return false;
		}
		else {
			return true;
		}		
	}

	@Override
	public boolean checkLastName(String lastName) {//soyismi en az 2 harf-karakter olacak

		if (lastName.length() < 2) {
			System.out.println("Soy ismi 2 karakterden az olamaz!");
			return false;
		}
		else {
			return true;
		}	
	}

	@Override
	public boolean checkMail(String eMail) {// e posta regex formatında olacak

		String regex = "[a-zA-Z][\\w-]{1,20}@\\w{2,20}\\.\\w{2,3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(eMail);
		return matcher.matches();
	}

	@Override
	public boolean checkMailIsUseable(String eMail, List<User> users) { //e mail daha önce kullanılmamış olacak
	
		for (User user : users) {
			
			if (user.geteMail().equals(eMail)) {
				System.out.println("Bu e-mail daha önce kullanılmış! Yeni bir email giriniz.");
				return false;
			}
		}
		return true;	
	}

	@Override
	public boolean checkPassword(String password) {// şifre en az 6 harf-karakter olacak

		if (password.length() < 6) {
			System.out.println("Parola 6 karakterden az olamaz!");
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean isValidUser(User user) {
		
		if ( (checkFirstName(user.getFirstName())) && (checkLastName(user.getLastName())) 
				&& (checkPassword(user.getPassword())) && (checkMail(user.geteMail()))  ) {
			return true;
		}
		else {
			return false;
		}
	}
}
