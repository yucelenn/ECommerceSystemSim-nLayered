package ecs.business.concretes.adapters;

import ecs.business.abstracts.IntegrationService;

public class YandexIntegrationManager implements IntegrationService {

	private int id = 11;
	private String firstName = "Ayşe";	
	private String lastName ="Yücel";
	private String eMail ="ayseycl@yandexmail.com"; // bilgiler Yandex'ten geliyor simülasyonu için oluşturdum.
	private String password ="aycaycayc";
		
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public int autoId() {
	
		return getId();
	}

	@Override
	public String autoFirstName() {

		return getFirstName();
	}

	@Override
	public String autoLastName() {
		
		return getLastName();
	}

	@Override
	public String autoEMail() {
		
		return geteMail();
	}

	@Override
	public String autoPassword() {
		
		return getPassword();
	}
	
}
