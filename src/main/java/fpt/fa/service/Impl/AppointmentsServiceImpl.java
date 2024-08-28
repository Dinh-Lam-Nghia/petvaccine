package fpt.fa.service.Impl;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fpt.fa.entity.Appointments;
import fpt.fa.repository.AppointmentsRepository;
import fpt.fa.service.AppointmentsService;

@Service
public class AppointmentsServiceImpl implements AppointmentsService {

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @Override
    public long countAppointmentsWithDelete1() {
        return appointmentsRepository.countByDelete(1);
    }
    @Override
    public List<Appointments> getAllAppointments() {
        List<Appointments> appointments = appointmentsRepository.findAll();
        // Sắp xếp cuộc hẹn chưa chấp nhận (isdelete = 2) lên trước cuộc hẹn đã chấp nhận (isdelete = 1)
        return appointments.stream()
                .sorted(Comparator.comparingInt(Appointments::getDelete)
                        .thenComparing(Appointments::getAppointmentDate)) // Thêm sắp xếp theo ngày nếu cần
                .collect(Collectors.toList());
    }

    @Override
    public Appointments getAppointmentById(int id) {
        Optional<Appointments> appointment = appointmentsRepository.findById(id);
        return appointment.orElse(null);
    }

    @Override
    public Appointments saveAppointment(Appointments appointment) {
        return appointmentsRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(int id) {
        appointmentsRepository.deleteById(id);
    }

    @Override
    public List<Appointments> getAppointmentsByStatus(int status) {
        return appointmentsRepository.findByDelete(status);
    }

    @Override
    public void updateStatus(int appointmentID, int status) {
        Optional<Appointments> appointmentOpt = appointmentsRepository.findById(appointmentID);
        if (appointmentOpt.isPresent()) {
            Appointments appointment = appointmentOpt.get();
            appointment.setDelete(status);
            appointmentsRepository.save(appointment);
        }
    }
}




