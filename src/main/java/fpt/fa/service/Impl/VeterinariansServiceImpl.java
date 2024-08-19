package fpt.fa.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entity.Veterinarians;
import fpt.fa.repository.VeterinariansRepository;
import fpt.fa.service.VeterinariansService;

@Service
public class VeterinariansServiceImpl implements VeterinariansService {

    @Autowired
    private VeterinariansRepository veterinariansRepository;

    @Override
    public List<Veterinarians> getAllVeterinarians() {
        return veterinariansRepository.findByDelete(1);
    }

    @Override
    public Veterinarians getVeterinarianById(int veterinarianID) {
        Optional<Veterinarians> optionalVeterinarian = veterinariansRepository.findById(veterinarianID);
        return optionalVeterinarian.orElse(null);
    }

    @Override
    public Veterinarians createVeterinarians(Veterinarians veterinarians) {
        return veterinariansRepository.save(veterinarians);
    }

    @Override
    public Veterinarians updateVeterinarians(Veterinarians veterinarians) {
        return veterinariansRepository.save(veterinarians);
    }

    @Override
    public void deleteVeterinarians(int veterinarianID) {
        Veterinarians veterinarian = veterinariansRepository.findById(veterinarianID).orElse(null);
        if (veterinarian != null) {
            veterinarian.setDelete(0);
            veterinariansRepository.save(veterinarian);
        }
    }
    
    @Override
    public List<Veterinarians> searchVeterinarians(String keyword) {
        return veterinariansRepository.searchVeterinarians(keyword);
    }
}
