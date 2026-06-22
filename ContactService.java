package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	//Store contacts using the contact ID as the key
	private final Map<String, Contact> contacts = new HashMap<>();
	
	public boolean addContact(Contact contact) {
		
		//Do not add null contacts or duplicate IDs
		if (contact == null || contacts.containsKey(contact.getContactId())) {
			return false;
		}
		
		contacts.put(contact.getContactId(), contact);
		return true;
	}
	
	public boolean deleteContact(String contactId) {
		
		//Verify contact exists before deleting
		if (contactId == null || !contacts.containsKey(contactId)) {
			return false;
		}
		
		contacts.remove(contactId);
		return true;
	}
	
	public boolean updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		
		Contact contact = contacts.get(contactId);
		
		//Cannot update a contact that does not exist
		if (contact == null) {
			return false;
		}
		
		//Only update fields that were passed in
		if (firstName != null) {
			contact.setFirstName(firstName);
		}
		
		if (lastName != null) {
			contact.setLastName(lastName);
		}
		
		if (phone != null) {
			contact.setPhone(phone);
		}
		
		if (address != null) {
			contact.setAddress(address);
		}
		
		return true;
	}
	
	//Helper method used in tests
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
}
