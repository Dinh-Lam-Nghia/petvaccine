package fpt.fa.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entity.Pets;
import fpt.fa.entity.VaccinationRecords;
import fpt.fa.entity.Vaccines;
import fpt.fa.entity.Veterinarians;
import fpt.fa.repository.PetsRepository;
import fpt.fa.repository.VaccinesRepository;
import fpt.fa.repository.VeterinariansRepository;
import fpt.fa.repository.vaccinationrecordsRepository;
import fpt.fa.service.VaccinationrecordsService;

@Service
public class VaccinationrecordsServiceImpl implements VaccinationrecordsService {
	@Autowired
	private vaccinationrecordsRepository vaccinationrecordsRepository;
	@Autowired
	private PetsRepository petsRepository;
	
	@Autowired
	private VaccinesRepository vaccinesRepository;
	@Autowired
	private VeterinariansRepository veterinariansRepository;
	
	@Override
	public void create(VaccinationRecords vaccinationRecords) {
		vaccinationrecordsRepository.save(vaccinationRecords);
	}

	@Override
	public List<VaccinationRecords> findByDelete(int delete) { 
		return vaccinationrecordsRepository.findByDelete(1);
	}

	@Override
	public void deleteById(int id) {
		VaccinationRecords vaccinationRecords = vaccinationrecordsRepository.findById(id).orElse(null);
		if(vaccinationRecords != null) {
			vaccinationRecords.setDelete(0);
			vaccinationrecordsRepository.save(vaccinationRecords);
		}
	}

	@Override
	public VaccinationRecords findById(int id) { 
		return vaccinationrecordsRepository.findById(id).orElse(null);
	}

	@Override
	public List<VaccinationRecords> search(String search) {
		
		Pets pets = petsRepository.findByPetName(search);
		Vaccines vaccines = vaccinesRepository.findByVaccineName(search);
		Veterinarians veterinarians = veterinariansRepository.findByVeterinarianName(search);
		
		return vaccinationrecordsRepository.findByPetIDOrVaccineIDOrVaccinationDateOrVeterinarianIDOrNextDueDateAndDelete(pets, vaccines, null, veterinarians, null, 1);
	
	} 

}
