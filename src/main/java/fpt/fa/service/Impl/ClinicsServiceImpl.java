package fpt.fa.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fpt.fa.entity.Clinics;
import fpt.fa.repository.ClinicsRepository;
import fpt.fa.service.ClinicsService;

@Service
public class ClinicsServiceImpl implements ClinicsService {

    @Autowired
    private ClinicsRepository clinicsRepository;

    @Override
    public List<Clinics> getAllClinics() {
        return clinicsRepository.findByDelete(1);
    }

    @Override
    public Clinics getClinicById(int clinicID) {
        return clinicsRepository.findById(clinicID).orElse(null);
    }

    @Override
    public Clinics createClinic(Clinics clinic) {
        clinic.setDelete(1);
        return clinicsRepository.save(clinic);
    }

    @Override
    public Clinics updateClinic(Clinics clinic) {
        return clinicsRepository.save(clinic);
    }

    @Override
    public void deleteClinic(int clinicID) {
        Clinics clinic = clinicsRepository.findById(clinicID).orElse(null);
        if (clinic != null) {
            clinic.setDelete(0);
            clinicsRepository.save(clinic);
        }
    }

    @Override
    public List<Clinics> searchClinics(String keyword) {
        return clinicsRepository.findByClinicNameContainingOrAddressContainingOrPhoneNumberContainingAndDelete(
            keyword, keyword, keyword, 1);
    }
    //có lỗi 
//    @Override
//    public void importClinicsFromExcel(MultipartFile file) {
//        try (InputStream inputStream = file.getInputStream();
//             Workbook workbook = WorkbookFactory.create(inputStream)) {
//
//            Sheet sheet = workbook.getSheetAt(0); // Giả sử dữ liệu nằm ở sheet đầu tiên
//
//            for (Row row : sheet) {
//                if (row.getRowNum() == 0) {
//                    continue; // Bỏ qua hàng tiêu đề
//                }
//
//                Clinics clinic = new Clinics();
//                clinic.setClinicName(row.getCell(0).getStringCellValue());
//                clinic.setAddress(row.getCell(1).getStringCellValue());
//                clinic.setPhoneNumber(row.getCell(2).getStringCellValue());
//
//                clinicsRepository.save(clinic); // Lưu phòng khám vào database
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Bạn có thể thêm xử lý ngoại lệ tại đây
//        }
//    }

	@Override
	public void importClinicsFromExcel(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}
}
