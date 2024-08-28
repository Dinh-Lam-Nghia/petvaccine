package fpt.fa.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.fa.service.AppointmentsService;
import fpt.fa.service.ClinicsService;
import fpt.fa.service.PetOwnersService;
import fpt.fa.service.PetsService;
import fpt.fa.service.VeterinariansService;
import fpt.fa.entity.Appointments;

@Controller
@RequestMapping("/appointments")
public class AppointmentsController {

    @Autowired
    private AppointmentsService appointmentsService;
    
    @Autowired
    private PetsService petsService;

    @Autowired
    private PetOwnersService petOwnersService;

    @Autowired
    private VeterinariansService veterinariansService;

    @Autowired
    private ClinicsService clinicsService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("appointment", new Appointments());

        // Lấy danh sách các đối tượng không bị xóa
        model.addAttribute("pets", petsService.getActivePets());
        model.addAttribute("owners", petOwnersService.getActivePetOwners());
        model.addAttribute("veterinarians", veterinariansService.getActiveVeterinarians());
        model.addAttribute("clinics", clinicsService.getActiveClinics());
        model.addAttribute("menu_appointments", "active");
        return "appointments/create";
    }

    @PostMapping("/create")
    public String createAppointment(Appointments appointment, Model model) {
        // Lưu cuộc hẹn với isDelete = 1
        appointment.setDelete(2);
        appointmentsService.saveAppointment(appointment);
        return "redirect:/appointments/list";
    }

    @GetMapping("/list")
    public String listAppointments(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Appointments> appointmentsList;
        if (keyword != null && !keyword.isEmpty()) {
            appointmentsList = appointmentsService.getAllAppointments().stream()
                    .filter(a -> a.getPetID().getPetName().contains(keyword) || a.getOwnerID().getOwnerName().contains(keyword))
                    .collect(Collectors.toList());
        } else {
            appointmentsList = appointmentsService.getAllAppointments();
        }
        model.addAttribute("appointmentsList", appointmentsList);
        return "appointments/list";
    }


    @GetMapping("/accept/{id}")
    public String acceptAppointment(@PathVariable("id") int id) {
        appointmentsService.updateStatus(id, 1);
        return "redirect:/appointments/list";
    }

    @GetMapping("/reject/{id}")
    public String rejectAppointment(@PathVariable("id") int id) {
        appointmentsService.updateStatus(id, 0);
        return "redirect:/appointments/list";
    }

    @GetMapping("/edit/{id}")
    public String editAppointment(@PathVariable("id") int id, Model model) {
        Appointments appointment = appointmentsService.getAppointmentById(id);
        model.addAttribute("appointment", appointment);
        model.addAttribute("pets", petsService.getActivePets());
        model.addAttribute("owners", petOwnersService.getActivePetOwners());
        model.addAttribute("veterinarians", veterinariansService.getActiveVeterinarians());
        model.addAttribute("clinics", clinicsService.getActiveClinics());
        model.addAttribute("menu_appointments", "active");
        return "appointments/edit";
    }

    @PostMapping("/update")
    public String updateAppointment(Appointments appointment) {
        appointmentsService.saveAppointment(appointment);
        return "redirect:/appointments/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable("id") int id) {
        appointmentsService.updateStatus(id, 0); // Cập nhật trạng thái isDelete thành 0
        return "redirect:/appointments/list"; // Chuyển hướng đến danh sách cuộc hẹn
    }
}

