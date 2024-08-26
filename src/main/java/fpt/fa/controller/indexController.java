package fpt.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fpt.fa.service.PetOwnersService;

@Controller
public class indexController {

    @Autowired
    private PetOwnersService petOwnersService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Pet Vaccine");
        model.addAttribute("menu_index", "active");

        long deletedCustomers = petOwnersService.countDeletedCustomers();
        model.addAttribute("deletedCustomers", deletedCustomers);

        model.addAttribute("newCustomers", petOwnersService.getNewCustomersNotDeleted());

        return "index";
    }
}
