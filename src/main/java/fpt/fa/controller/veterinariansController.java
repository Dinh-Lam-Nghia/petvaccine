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
import fpt.fa.entity.Veterinarians;
import fpt.fa.service.VeterinariansService;

@Controller
@RequestMapping("/veterinarians")
public class veterinariansController {

    @Autowired
    private VeterinariansService veterinariansService;

    // Hiển thị danh sách bác sĩ
    @GetMapping("/list")
    public String listVeterinarians(Model model) {
        model.addAttribute("title", "Quản lý bác sĩ");
        model.addAttribute("menu_veterinarians", "active");
        model.addAttribute("veterinariansList", veterinariansService.getAllVeterinarians());
        return "veterinarians/list";
    }

    // Hiển thị trang thêm bác sĩ
    @GetMapping("/create")
    public String createVeterinarians(Model model) {
        model.addAttribute("title", "Thêm bác sĩ mới");
        model.addAttribute("menu_veterinarians", "active");
        model.addAttribute("veterinarian", new Veterinarians());
        return "veterinarians/create";
    }

    // Hiển thị trang chỉnh sửa bác sĩ
    @GetMapping("/edit/{id}")
    public String editVeterinarians(@PathVariable("id") int id, Model model) {
        Veterinarians veterinarian = veterinariansService.getVeterinarianById(id);
        if (veterinarian != null) {
            model.addAttribute("title", "Chỉnh sửa thông tin bác sĩ");
            model.addAttribute("menu_veterinarians", "active");
            model.addAttribute("veterinarian", veterinarian);
            return "veterinarians/edit";
        } else {
            // Trường hợp không tìm thấy bác sĩ với ID này, chuyển hướng về danh sách
            return "redirect:/veterinarians/list";
        }
    }

    // Xóa bác sĩ
    @GetMapping("/delete/{id}")
    public String deleteVeterinarian(@PathVariable("id") int id) {
        Veterinarians veterinarian = veterinariansService.getVeterinarianById(id);
        if (veterinarian != null) {
            veterinarian.setDelete(0);  // Đặt trạng thái delete thành 0 khi xóa
            veterinariansService.updateVeterinarians(veterinarian);
        }
        return "redirect:/veterinarians/list"; // Sau khi xóa, chuyển hướng về trang danh sách
    }

    // Thêm bác sĩ mới
    @PostMapping("/create")
    public String saveVeterinarian(@ModelAttribute("veterinarian") Veterinarians veterinarian, BindingResult result) {
        if (result.hasErrors()) {
            return "veterinarians/create";  // Nếu có lỗi, trả về form thêm mới
        }
        veterinarian.setDelete(1);  // Đặt mặc định là chưa bị xóa (delete = 1)
        veterinariansService.createVeterinarians(veterinarian);
        return "redirect:/veterinarians/list";  // Chuyển hướng về danh sách sau khi lưu
    }

    @PostMapping("/update")
    public String updateVeterinarian(@ModelAttribute("veterinarian") Veterinarians veterinarian) {
        // Kiểm tra xem ID có tồn tại không, nếu có thì cập nhật
        Veterinarians existingVeterinarian = veterinariansService.getVeterinarianById(veterinarian.getVeterinarianID());

        if (existingVeterinarian != null) {
            // Cập nhật các trường thông tin của bác sĩ hiện tại
            existingVeterinarian.setEmail(veterinarian.getEmail());
            existingVeterinarian.setVeterinarianName(veterinarian.getVeterinarianName());
            existingVeterinarian.setPhoneNumber(veterinarian.getPhoneNumber());

            veterinariansService.updateVeterinarians(existingVeterinarian);  // Lưu lại thông tin cập nhật
        }

        return "redirect:/veterinarians/list";  // Chuyển hướng về trang danh sách sau khi lưu
    }

}
