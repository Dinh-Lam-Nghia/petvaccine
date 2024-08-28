package fpt.fa.service;

import java.util.List;

import fpt.fa.entity.PetOwners;

public interface PetOwnersService {
	void create(PetOwners petOwners);
	List<PetOwners> findByDelete();
	void deleteById(int id);
	PetOwners findById(int id);
	void updateById(PetOwners petOwners);
	List<PetOwners> search(String search);
	long countDeletedCustomers();
	List<PetOwners> getNewCustomersNotDeleted();
	List<PetOwners> getActivePetOwners();
}
