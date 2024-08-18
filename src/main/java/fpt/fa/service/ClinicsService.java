package fpt.fa.service;

import java.util.List;
import fpt.fa.entity.Clinics;

public interface ClinicsService {
    List<Clinics> getAllClinics();
    Clinics getClinicById(int clinicID);
    Clinics createClinic(Clinics clinic);
    Clinics updateClinic(Clinics clinic);
    void deleteClinic(int clinicID);
}
