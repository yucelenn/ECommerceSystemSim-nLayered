package ecs.business.concretes.adapters;

import ecs.business.abstracts.IntegrationService;
import ecs.entities.concretes.User;

public class Adapter {

	private IntegrationService client; 

	public Adapter(IntegrationService integrationService) {
		super();
		this.client = integrationService;
	}
	
	public Adapter() {
		super();
	}
	
	public User getUserFromAdapter() {
		User adapterUser = new User(client.autoId(), client.autoFirstName(), client.autoLastName(), client.autoEMail(), client.autoPassword());
		return adapterUser;
	}
	
}
