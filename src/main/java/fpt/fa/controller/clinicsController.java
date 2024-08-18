package fpt.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.fa.entity.Clinics;
import fpt.fa.service.ClinicsService;

@Controller
@RequestMapping("/clinics")
public class clinicsController {

    @Autowired
    private ClinicsService clinicsService;

    // Hiển thị danh sách phòng khám
    @GetMapping("/list")
    public String listClinics(Model model) {
        model.addAttribute("title", "Quản lý phòng khám");
        model.addAttribute("menu_clinics", "active");
        model.addAttribute("clinicsList", clinicsService.getAllClinics());
        return "clinics/list";
    }

    // Hiển thị trang thêm phòng khám
    @GetMapping("/create")
    public String createClinicForm(Model model) {
        model.addAttribute("title", "Thêm phòng khám mới");
        model.addAttribute("menu_clinics", "active");
        model.addAttribute("clinic", new Clinics());
        return "clinics/create";
    }

    // Xử lý việc thêm phòng khám mới
    @PostMapping("/create")
    public String saveClinic(@ModelAttribute("clinic") Clinics clinic, BindingResult result) {
        if (result.hasErrors()) {
            return "clinics/create";
        }
        clinic.setDelete(1);  // Đặt mặc định là chưa bị xóa (1)
        clinicsService.createClinic(clinic);
        return "redirect:/clinics/list";
    }

    // Hiển thị trang chỉnh sửa phòng khám
    @GetMapping("/edit/{id}")
    public String editClinicForm(@PathVariable("id") int id, Model model) {
        Clinics clinic = clinicsService.getClinicById(id);
        if (clinic != null) {
            model.addAttribute("title", "Chỉnh sửa phòng khám");
            model.addAttribute("menu_clinics", "active");
            model.addAttribute("clinic", clinic);
            return "clinics/edit";
        } else {
            return "redirect:/clinics/list";
        }
    }

    // Xử lý việc cập nhật thông tin phòng khám
    @PostMapping("/edit")
    public String updateClinic(@ModelAttribute("clinic") Clinics clinic) {
    	clinic.setDelete(1);
        clinicsService.updateClinic(clinic);
        return "redirect:/clinics/list";
    }

    // Xóa phòng khám (cập nhật trường delete thành 0)
    @GetMapping("/delete/{id}")
    public String deleteClinic(@PathVariable("id") int id) {
        Clinics clinic = clinicsService.getClinicById(id);
        if (clinic != null) {
            clinic.setDelete(0);  // Đặt trạng thái bị xóa (0)
            clinicsService.updateClinic(clinic);
        }
        return "redirect:/clinics/list";
    }
}
