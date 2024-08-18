package fpt.fa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entity.Clinics;
import fpt.fa.repository.ClinicsRepository;

@Service
public class ClinicsServiceImpl implements ClinicsService {

    @Autowired
    private ClinicsRepository clinicsRepository;

    @Override
    public List<Clinics> getAllClinics() {
        return clinicsRepository.findByDelete(1);  // Chỉ lấy những phòng khám chưa bị xóa (delete = 1)
    }

    @Override
    public Clinics getClinicById(int clinicID) {
        Optional<Clinics> optionalClinic = clinicsRepository.findById(clinicID);
        return optionalClinic.orElse(null);  // Trả về phòng khám nếu tìm thấy, nếu không trả về null
    }

    @Override
    public Clinics createClinic(Clinics clinic) {
        clinic.setDelete(1);  // Đặt delete mặc định là 1 khi tạo mới
        return clinicsRepository.save(clinic);
    }

    @Override
    public Clinics updateClinic(Clinics clinic) {
        // Giả sử clinicID đã được đặt và tồn tại trong cơ sở dữ liệu
        return clinicsRepository.save(clinic);
    }

    @Override
    public void deleteClinic(int clinicID) {
        Clinics clinic = clinicsRepository.findById(clinicID).orElse(null);
        if (clinic != null) {
            clinic.setDelete(0);  // Đặt delete thành 0 để đánh dấu là đã bị xóa
            clinicsRepository.save(clinic);  // Cập nhật phòng khám với trạng thái mới
        }
    }
}
