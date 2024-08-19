package fpt.fa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fpt.fa.entity.Clinics;

@Repository
public interface ClinicsRepository extends JpaRepository<Clinics, Integer> {
    List<Clinics> findByDelete(int delete);
    
    // Tìm kiếm theo tên, địa chỉ hoặc số điện thoại và chưa bị xóa
    List<Clinics> findByClinicNameContainingOrAddressContainingOrPhoneNumberContainingAndDelete(
        String clinicName, String address, String phoneNumber, int delete);
}
