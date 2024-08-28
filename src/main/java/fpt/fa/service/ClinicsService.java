package fpt.fa.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import fpt.fa.entity.Clinics;

public interface ClinicsService {
    List<Clinics> getAllClinics();
    Clinics getClinicById(int clinicID);
    Clinics createClinic(Clinics clinic);
    Clinics updateClinic(Clinics clinic);
    void deleteClinic(int clinicID);
    List<Clinics> searchClinics(String keyword);
    void importClinicsFromExcel(MultipartFile file);
    List<Clinics> getActiveClinics();
}
