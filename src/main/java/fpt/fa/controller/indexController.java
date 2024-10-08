package fpt.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.fa.service.AppointmentsService;
import fpt.fa.service.PetOwnersService;
import fpt.fa.service.PetsService;
import fpt.fa.service.VaccinesService;
import fpt.fa.entity.Vaccines;

@Controller
@RequestMapping("/")
public class indexController {

    @Autowired
    private PetOwnersService petOwnersService;

    @Autowired
    private PetsService petsService;

    @Autowired
    private VaccinesService vaccinesService;
    
    @Autowired
    private AppointmentsService appointmentsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Trang chính - Quản lý vaccine thú cưng");
        model.addAttribute("menu_index", "active");

        long deletedCustomers = petOwnersService.countDeletedCustomers();
        model.addAttribute("deletedCustomers", deletedCustomers);

        model.addAttribute("newCustomers", petOwnersService.getNewCustomersNotDeleted());

        long deletedPets = petsService.countDeletedPets();
        model.addAttribute("deletedPets", deletedPets);

        Page<Vaccines> vaccinesPage = vaccinesService.getListVaccinesWithPaging(PageRequest.of(0, 5)); // Ví dụ lấy 5 vaccine đầu tiên
        model.addAttribute("vaccines", vaccinesPage);
        
        long totalVaccines = vaccinesService.countAllVaccines();
        model.addAttribute("totalVaccines", totalVaccines);

        long deletedVaccines = vaccinesService.countDeletedVaccines();
        model.addAttribute("deletedVaccines", deletedVaccines);
        
        long deletedAppointments = appointmentsService.countAppointmentsWithDelete1();
        model.addAttribute("deletedAppointments", deletedAppointments);

        return "index";
    }
}
