package fpt.fa.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fpt.fa.entity.PetOwners;
import fpt.fa.entity.Pets;

public interface PetsRepository extends JpaRepository<Pets, Integer> {
	List<Pets> findByDelete(int delete); 

	List<Pets> findByOwnerIDOrPetNameOrSpeciesOrBreedOrDateOfBirthOrGenderOrMicrochipIDAndDelete(PetOwners ownerID,
			String petName, String species, String breed, Date dateOfBirth, String gender, String microchipID,
			int delete);
	long countByDelete(int deleteValue);
	
	Pets findByPetName(String petName);
}
