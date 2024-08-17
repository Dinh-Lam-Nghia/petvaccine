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
        Veterinarians veterinarian = veterinariansService.getVeterinariansById(id);
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
        veterinariansService.deleteVeterinarians(id);
        return "redirect:/veterinarians/list"; // Sau khi xóa, chuyển hướng về trang danh sách
    }

    // Thêm bác sĩ mới
    @PostMapping("/save")
    public String saveVeterinarian(@ModelAttribute("veterinarian") Veterinarians veterinarian, BindingResult result) {
        if (result.hasErrors()) {
            return "veterinarians/create";  // Nếu có lỗi, trả về form thêm mới
        }
        veterinarian.setDelete(0);  // Đặt mặc định là chưa bị xóa
        veterinariansService.createVeterinarians(veterinarian);
        return "redirect:/veterinarians/list";  // Chuyển hướng về danh sách sau khi lưu
    }

    // Cập nhật thông tin bác sĩ
    @PostMapping("/update")
    public String updateVeterinarian(@ModelAttribute("veterinarian") Veterinarians veterinarian) {
        // Kiểm tra xem bác sĩ có tồn tại trong database hay không bằng cách tìm theo ID
        Veterinarians existingVeterinarian = veterinariansService.getVeterinariansById(veterinarian.getVeterinarianID());

        if (existingVeterinarian != null) {
            // Cập nhật thông tin bác sĩ đã có, dù không có thay đổi gì
            existingVeterinarian.setEmail(veterinarian.getEmail());
            existingVeterinarian.setVeterinarianName(veterinarian.getVeterinarianName());
            existingVeterinarian.setPhoneNumber(veterinarian.getPhoneNumber());

            // Đặt thuộc tính delete thành 0, dù không có thay đổi gì
            existingVeterinarian.setDelete(0);

            // Lưu lại thông tin cập nhật hoặc không thay đổi
            veterinariansService.updateVeterinarians(existingVeterinarian);
        }

        return "redirect:/veterinarians/list";  // Chuyển hướng về trang danh sách sau khi lưu
    }

}
