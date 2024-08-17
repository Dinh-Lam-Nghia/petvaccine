package fpt.fa.service;

import java.util.List;
import fpt.fa.entity.Clinics;

public interface ClinicsService {
    List<Clinics> findAllActiveClinics();

    Clinics findById(int id);

    void save(Clinics clinic);

    void softDeleteClinic(int id);

    List<Clinics> searchClinicsByKeyword(String keyword);
}
