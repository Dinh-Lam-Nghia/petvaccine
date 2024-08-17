package fpt.fa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fpt.fa.entity.Clinics;
import fpt.fa.service.ClinicsService;

@Controller
@RequestMapping("/clinics")
public class clinicsController {

    @Autowired
    private ClinicsService clinicsService;

    // Hiển thị danh sách phòng khám
    @GetMapping("/list")
    public String listClinics(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Clinics> clinicsList;
        if (keyword != null && !keyword.isEmpty()) {
            clinicsList = clinicsService.searchClinicsByKeyword(keyword);
            model.addAttribute("keyword", keyword);  // Giữ lại từ khóa trong form tìm kiếm
        } else {
            clinicsList = clinicsService.findAllActiveClinics();
        }
        model.addAttribute("clinicsList", clinicsList);
        model.addAttribute("title", "Quản lý phòng khám");
        model.addAttribute("menu_clinics", "active");
        return "clinics/list";  // Trả về trang danh sách clinics/list.jsp
    }

    // Hiển thị form tạo phòng khám mới
    @GetMapping("/create")
    public String createClinicForm(Model model) {
        model.addAttribute("title", "Thêm phòng khám mới");
        model.addAttribute("menu_clinics", "active");
        model.addAttribute("clinic", new Clinics());  // Khởi tạo đối tượng clinic rỗng
        return "clinics/create";  // Trả về trang tạo clinics/create.jsp
    }

    // Lưu phòng khám mới
    @PostMapping("/save")
    public String saveClinic(@ModelAttribute("clinic") Clinics clinic, RedirectAttributes redirectAttributes) {
        try {
            clinicsService.save(clinic);
            redirectAttributes.addFlashAttribute("successMessage", "Phòng khám đã được lưu thành công.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra khi lưu phòng khám.");
        }
        return "redirect:/clinics/list";  // Chuyển hướng về danh sách sau khi lưu
    }

    // Hiển thị form chỉnh sửa phòng khám với dữ liệu phòng khám
    @GetMapping("/edit/{id}")
    public String editClinicForm(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        Clinics clinic = clinicsService.findById(id);
        if (clinic != null) {
            model.addAttribute("clinic", clinic);
            model.addAttribute("title", "Chỉnh sửa phòng khám");
            model.addAttribute("menu_clinics", "active");
            return "clinics/edit";  // Trả về trang chỉnh sửa clinics/edit.jsp
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Phòng khám không tồn tại.");
            return "redirect:/clinics/list";
        }
    }

    // Cập nhật thông tin phòng khám
    @PostMapping("/update")
    public String updateClinic(@ModelAttribute("clinic") Clinics clinic, RedirectAttributes redirectAttributes) {
        try {
            clinicsService.save(clinic);
            redirectAttributes.addFlashAttribute("successMessage", "Phòng khám đã được cập nhật thành công.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra khi cập nhật phòng khám.");
        }
        return "redirect:/clinics/list";  // Chuyển hướng về danh sách sau khi cập nhật
    }

    // Xóa phòng khám (chuyển trạng thái đã xóa)
    @GetMapping("/delete/{id}")
    public String deleteClinic(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        try {
            clinicsService.softDeleteClinic(id);
            redirectAttributes.addFlashAttribute("successMessage", "Phòng khám đã được xóa thành công.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra khi xóa phòng khám.");
        }
        return "redirect:/clinics/list";  // Chuyển hướng về danh sách sau khi xóa
    }
}
