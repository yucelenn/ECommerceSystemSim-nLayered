package ecs.business.concretes.validators;

import ecs.business.abstracts.ValidationCheckService;

public class SmsValidationCheckManager implements ValidationCheckService {

	@Override
	public boolean validate() { // kullanıcı doğrulama sms'ini aldı ve linke tıkladı simülasyonu

		System.out.println("Doğrulama başarılı.");
		return true;
	}

}
