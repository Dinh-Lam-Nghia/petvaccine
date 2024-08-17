package fpt.fa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entity.Veterinarians;
import fpt.fa.repository.VeterinariansRepository;

@Service
public class VeterinariansServiceImpl implements VeterinariansService {
    @Autowired
    private VeterinariansRepository veterinariansRepository;

    @Override
    public List<Veterinarians> getAllVeterinarians() {
        return veterinariansRepository.findByDelete(0);
    }

    @Override
    public Veterinarians getVeterinariansById(int veterinarianID) {
        Optional<Veterinarians> optionalVeterinarian = veterinariansRepository.findById(veterinarianID);
        return optionalVeterinarian.orElse(null);  // Return the veterinarian if found, otherwise return null
    }

    @Override
    public Veterinarians createVeterinarians(Veterinarians veterinarian) {
        return veterinariansRepository.save(veterinarian);
    }

    @Override
    public Veterinarians updateVeterinarians(Veterinarians veterinarians) {
        return veterinariansRepository.save(veterinarians);
    }


    @Override
    public void deleteVeterinarians(int veterinarianID) {
        Veterinarians veterinarian = veterinariansRepository.findById(veterinarianID).orElse(null);
        if (veterinarian != null) {
            veterinarian.setDelete(1);
            veterinariansRepository.save(veterinarian);
        }
    }
}
