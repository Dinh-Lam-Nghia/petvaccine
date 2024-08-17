package fpt.fa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entity.Clinics;
import fpt.fa.repository.ClinicsRepository;
import fpt.fa.service.ClinicsService;

@Service
public class ClinicsServiceImpl implements ClinicsService {

    @Autowired
    private ClinicsRepository clinicsRepository;

    @Override
    public List<Clinics> findAllActiveClinics() {
        // Lấy danh sách các phòng khám chưa bị xóa (delete = 0)
        return clinicsRepository.findByDelete(0);
    }

    @Override
    public Clinics findById(int id) {
        // Tìm phòng khám theo ID
        return clinicsRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Clinics clinic) {
        // Lưu thông tin phòng khám
        clinicsRepository.save(clinic);
    }

    @Override
    public void softDeleteClinic(int id) {
        // Đánh dấu phòng khám là đã xóa (delete = 1)
        Clinics clinic = clinicsRepository.findById(id).orElse(null);
        if (clinic != null) {
            clinic.setDelete(1);
            clinicsRepository.save(clinic);
        }
    }

    @Override
    public List<Clinics> searchClinicsByKeyword(String keyword) {
        // Tìm kiếm phòng khám theo từ khóa (dựa trên tên hoặc địa chỉ)
        return clinicsRepository.searchClinicsByKeyword(keyword);
    }
}
