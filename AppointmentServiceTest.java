package appointmentTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import appointment.AppointmentService;

public class AppointmentServiceTest {
	private AppointmentService service;
	private Date futureDate;
	
	@BeforeEach
	public void setup() {
		service = new AppointmentService();
		futureDate = new Date(System.currentTimeMillis() + 86400000);
	}

	@Test
	public void testAddAppointmentSuccess() {
		Appointment appointment = new Appointment("1", futureDate, "Description");
		
		assertTrue(service.addAppointment(appointment));
		assertEquals(appointment, service.getAppointment("1"));
	}
	
	@Test
	public void testAddDuplicateAppointmentIdFails() {
		Appointment appointment1 = new Appointment("1", futureDate, "Description");
		Appointment appointment2 = new Appointment("1", futureDate, "Different Description");
		
		assertTrue(service.addAppointment(appointment1));
		assertFalse(service.addAppointment(appointment2));
	}
	
	@Test
	public void testAddNullAppointmentFails() {
		assertFalse(service.addAppointment(null));
	}
	
	@Test
	public void testDeleteAppointmentSuccess() {
		Appointment appointment = new Appointment("1", futureDate, "Description");
		service.addAppointment(appointment);
		
		assertTrue(service.deleteAppointment("1"));
		assertNull(service.getAppointment("1"));
	}
	
	@Test
	public void testDeleteNonExistentAppointmentFails() {
		assertFalse(service.deleteAppointment("999"));
	}
	
	@Test
	public void testDeleteNullAppointmentIdFails() {
		assertFalse(service.deleteAppointment(null));
	}

}
