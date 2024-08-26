package fpt.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import fpt.fa.service.PetOwnersService;
import fpt.fa.service.PetsService;

@Controller
@RequestMapping("/")
public class indexController {

    @Autowired
    private PetOwnersService petOwnersService;

    @Autowired
    private PetsService petsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Pet Vaccine");
        model.addAttribute("menu_index", "active");

        long deletedCustomers = petOwnersService.countDeletedCustomers();
        model.addAttribute("deletedCustomers", deletedCustomers);

        model.addAttribute("newCustomers", petOwnersService.getNewCustomersNotDeleted());

        // Get the count of deleted pets and add to model
        long deletedPets = petsService.countDeletedPets();
        model.addAttribute("deletedPets", deletedPets);

        return "index";
    }
}
