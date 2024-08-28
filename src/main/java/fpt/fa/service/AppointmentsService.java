package fpt.fa.service;

import java.util.List;
import fpt.fa.entity.Appointments;

public interface AppointmentsService {
    List<Appointments> getAllAppointments();
    Appointments getAppointmentById(int id);
    Appointments saveAppointment(Appointments appointment);
    void deleteAppointment(int id);
    List<Appointments> getAppointmentsByStatus(int status);
    void updateStatus(int appointmentId, int status);
    long countAppointmentsWithDelete1();
}

