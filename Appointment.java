package appointment;

import java.util.Date;

public class Appointment {
	private final String appointmentId;
	private Date appointmentDate;
	private String description;
	
	public Appointment(String appointmentId, Date appointmentDate, String description) {
		if (appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid appointment ID: Must not be null and max 10 characters.");
		}
		
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointment date: Must not be null or in the past.");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description: Must not be null and max 50 characters.");
		}
		
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDescription() {
		return description;
	}
}
