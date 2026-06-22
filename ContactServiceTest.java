package contactTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

public class ContactServiceTest {
	
	private ContactService service;
	
	@BeforeEach
	public void setUp() {
		
		//Create a fresh service before each test
		service = new ContactService();
	}

	@Test
	public void testAddContactSuccess() {
		
		Contact contact = new Contact(
				"1",
				"Jane",
				"Smith",
				"0987654321",
				"456 Oak Ave"
		);
		
		assertTrue(service.addContact(contact));
		assertEquals(contact, service.getContact("1"));
	}
	
	@Test
	public void testAddDuplicateContactIdFails() {
		
		Contact contact1 = new Contact(
				"1",
				"Jane",
				"Smith",
				"0987654321",
				"456 Oak Ave"
		);
		
		Contact contact2 = new Contact(
				"1",
				"Bob",
				"Jones",
				"1112223333",
				"789 Pine Rd"
		);
		
		assertTrue(service.addContact(contact1));
		assertFalse(service.addContact(contact2));
	}
	
	@Test
	public void testAddNullContactFails() {
		
		assertFalse(service.addContact(null));
	}
	
	@Test
	public void testDeleteContactSuccess() {
		
		Contact contact = new Contact(
				"1",
				"Jane",
				"Smith",
				"0987654321",
				"456 Oak Ave"
		);
		
		service.addContact(contact);
		
		assertTrue(service.deleteContact("1"));
		assertNull(service.getContact("1"));
	}
	
	@Test
	public void testDeleteNonExistentContactFails() {
		
		assertFalse(service.deleteContact("999"));
	}
	
	@Test
	public void testDeleteNullContactIdFails() {
		
		assertFalse(service.deleteContact(null));
	}
	
	@Test
	public void testUpdateContactSuccess() {
		
		Contact contact = new Contact(
				"1",
				"Jane",
				"Smith",
				"0987654321",
				"456 Oak Ave"
		);
		
		service.addContact(contact);
		
		assertTrue(service.updateContact(
				"1",
				"Alice",
				"Brown",
				"5556667777",
				"999 Maple Dr"
		));
		
		Contact updated = service.getContact("1");
		
		assertEquals("Alice", updated.getFirstName());
		assertEquals("Brown", updated.getLastName());
		assertEquals("5556667777", updated.getPhone());
		assertEquals("999 Maple Dr", updated.getAddress());
	}
	
	@Test
	public void testUpdateFirstNameOnly() {
		
		Contact contact = new Contact(
				"1",
				"Jane",
				"Smith",
				"0987654321",
				"456 Oak Ave"
		);
		
		service.addContact(contact);
		
		assertTrue(service.updateContact(
				"1",
				"Alice",
				null,
				null,
				null
		));
		
		Contact updated = service.getContact("1");
		
		assertEquals("Alice", updated.getFirstName());
		assertEquals("Smith", updated.getLastName());
		assertEquals("0987654321", updated.getPhone());
		assertEquals("456 Oak Ave", updated.getAddress());
	}
	
	@Test
	public void testUpdateNonExistentContactFails() {
		
		assertFalse(service.updateContact(
				"999",
				"Alice",
				"Brown",
				"5556667777",
				"999 Maple Dr"
		));
	}
	
	@Test
	public void testUpdateInvalidPhoneThrowsException() {
		
		Contact contact = new Contact(
				"1",
				"Jane",
				"Smith",
				"0987654321",
				"456 Oak Ave"
		);
		
		service.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, () -> {
			
			service.updateContact(
					"1",
					null,
					null,
					"555ABC7777",
					null
			);
		});
	}
	
	@Test
	public void testUpdateInvalidAddressThrowsException() {
		
		Contact contact = new Contact(
				"1",
				"Jane",
				"Smith",
				"0987654321",
				"456 Oak Ave"
		);
		
		service.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, () -> {
			
			service.updateContact(
					"1",
					null,
					null,
					null,
					"This address is definitely over thirty characters"
			);
		});
	}
}
