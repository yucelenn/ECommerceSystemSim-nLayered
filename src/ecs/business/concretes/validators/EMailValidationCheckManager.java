package ecs.business.concretes.validators;

import ecs.business.abstracts.ValidationCheckService;

public class EMailValidationCheckManager implements ValidationCheckService {

	@Override
	public boolean validate() { // kullanıcı doğrulama e-postasını aldı ve linke tıkladı simulasyonu için.
		
		System.out.println("Doğrulama başarılı.");
		return true;
	}

}
