package contactTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact.Contact;

public class ContactTest {

	@Test
	public void testContactCreationSuccess() {
		
		Contact contact = new Contact(
				"12345",
				"John",
				"Doe",
				"1234567890",
				"123 Main St"
		);
		
		assertEquals("12345", contact.getContactId());
		assertEquals("John", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Main St", contact.getAddress());
	}
	
	@Test
	public void testContactIdTooLong() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345678901",
					"John",
					"Doe",
					"1234567890",
					"123 Main St"
			);
		});
	}
	
	@Test
	public void testContactIdNull() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					null,
					"John",
					"Doe",
					"1234567890",
					"123 Main St"
			);
		});
	}
	
	@Test
	public void testFirstNameTooLong() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"123",
					"JohnJohnJohn",
					"Doe",
					"1234567890",
					"123 Main St"
			);
		});
	}
	
	@Test
	public void testFirstNameNull() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"123",
					null,
					"Doe",
					"1234567890",
					"123 Main St"
			);
		});
	}
	
	@Test
	public void testLastNameTooLong() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"123",
					"John",
					"DoeDoeDoeDoe",
					"1234567890",
					"123 Main St"
			);
		});
	}
	
	@Test
	public void testLastNameNull() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"123",
					"John",
					null,
					"1234567890",
					"123 Main St"
			);
		});
	}
	
	@Test
	public void testPhoneTooShort() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"123",
					"John",
					"Doe",
					"12345",
					"123 Main St"
			);
		});
	}
	
	@Test
	public void testPhoneTooLong() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"123",
					"John",
					"Doe",
					"12345678901",
					"123 Main St"
			);
		});
	}
	
	@Test
	public void testPhoneContainsLetters() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"123",
					"John",
					"Doe",
					"12345abcde",
					"123 Main St"
			);
		});
	}
	
	@Test
	public void testPhoneNull() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"123",
					"John",
					"Doe",
					null,
					"123 Main St"
			);
		});
	}
	
	@Test
	public void testAddressTooLong() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"123",
					"John",
					"Doe",
					"1234567890",
					"This address is over thirty characters long"
			);
		});
	}
	
	@Test
	public void testAddressNull() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"123",
					"John",
					"Doe",
					"1234567890",
					null
			);
		});
	}
}
