package fpt.fa.service;

import java.util.List;

import fpt.fa.entity.Veterinarians;

public interface VeterinariansService {
    List<Veterinarians> getAllVeterinarians();
    Veterinarians getVeterinarianById(int veterinarianID);
    Veterinarians createVeterinarians(Veterinarians veterinarians);
    Veterinarians updateVeterinarians(Veterinarians veterinarians);
    void deleteVeterinarians(int veterinarianID);
    List<Veterinarians> searchVeterinarians(String keyword);
}
