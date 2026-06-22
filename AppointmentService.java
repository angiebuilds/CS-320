package appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	private final Map<String, Appointment> appointments = new HashMap<>();
	
	public boolean addAppointment(Appointment appointment) {
		if (appointment == null || appointments.containsKey(appointment.getAppointmentId())) {
			return false;
		}
		
		appointments.put(appointment.getAppointmentId(), appointment);
			return true;
	}
	
	public boolean deleteAppointment(String appointmentId) {
		if (appointmentId == null || !appointments.containsKey(appointmentId)) {
			return false;
		}
		
		appointments.remove(appointmentId);
			return true;
	}
		
	public Appointment getAppointment(String appointmentId) {
		return appointments.get(appointmentId);
	}
}
