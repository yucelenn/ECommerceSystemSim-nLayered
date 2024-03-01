package ecs.business.concretes.adapters;

import ecs.business.abstracts.IntegrationService;

public class GoogleIntegrationManager implements IntegrationService {

	private int id = 10;
	private String firstName = "Hasan";	
	private String lastName ="Demir";
	private String eMail ="denemedeneme@gmail.com"; // bilgiler Google'dan geliyor simülasyonu için oluşturdum.
	private String password ="hasandemir";
		
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
