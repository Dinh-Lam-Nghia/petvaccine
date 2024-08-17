package fpt.fa.service;

import java.util.List;
import fpt.fa.entity.Veterinarians;

public interface VeterinariansService {
    List<Veterinarians> getAllVeterinarians();
    Veterinarians getVeterinariansById(int veterinariansID);
    Veterinarians createVeterinarians(Veterinarians veterinarians);
    Veterinarians updateVeterinarians(Veterinarians veterinarians);
    void deleteVeterinarians(int veterinariansID);
}
