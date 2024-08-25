package fpt.fa.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entity.PetOwners;
import fpt.fa.entity.Pets;
import fpt.fa.repository.PetOwnersRepository;
import fpt.fa.repository.PetsRepository;
import fpt.fa.service.PetsService;

@Service
public class PetsServiceImpl implements PetsService {
	@Autowired
	private PetsRepository petsRepository;
	@Autowired
	private PetOwnersRepository petOwnersRepository;

	@Override
	public void create(Pets pets) {
		petsRepository.save(pets);
	}

	@Override
	public List<Pets> findByDelete(int delete) { 
		return petsRepository.findByDelete(delete);
	}

	@Override
	public void deleteById(int id) {
		Pets pets = petsRepository.findById(id).orElse(null);
		if (pets != null) {
			pets.setDelete(0);
			petsRepository.save(pets);
		}
	}

	@Override
	public Pets findById(int id) { 
		return petsRepository.findById(id).orElse(null);
	}

	@Override
	public List<Pets> search(String search) {  
		PetOwners owner = petOwnersRepository.findByOwnerName(search);
		return petsRepository.findByOwnerIDOrPetNameOrSpeciesOrBreedOrDateOfBirthOrGenderOrMicrochipIDAndDelete(owner, search, search, search, null, search, search, 1);
	}
}
