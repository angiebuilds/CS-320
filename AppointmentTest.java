package appointmentTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

import appointment.Appointment;

class AppointmentTest {

	@Test
	public void testAppointmentCreationSuccess() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		Appointment appointment = new Appointment("12345", futureDate, "Doctor appointment");
		
		assertEquals("12345", appointment.getAppointmentId());
		assertEquals(futureDate, appointment.getAppointmentDate());
		assertEquals("Doctor appointment", appointment.getAppointmentDescription());
	}
	
	@Test
	public void testAppointmentIdTooLong() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678901", futureDate, "Doctor appointment");
		});
	}
	
	@Test
	public void testAppointmentIdNull() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, futureDate, "Doctor appointment");
		});
	}
	
	@Test
	public void testAppointmentDateNull() {		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", null, "Doctor appointment");
		});
	}
	
	@Test
	public void testAppointmentDateInPast() {
		Date pastDate = new Date(System.currentTimeMillis() - 86400000);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", pastDate, "Doctor appointment");
		});
	}
	
	@Test
	public void testDescriptionTooLong() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", futureDate, "This description string is intentionally made to be exceptionally long to trigger validation errors.");
		});
	}
	
	@Test
	public void testDescriptionNull() {
		Date futureDate = new Date(System.currentTimeMillis() + 86400000);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", futureDate, null);
		});
	}
}
