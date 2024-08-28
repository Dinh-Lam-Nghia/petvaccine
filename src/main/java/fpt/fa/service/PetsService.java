package fpt.fa.service;

import java.util.List;

import fpt.fa.entity.Pets;

public interface PetsService {
	void create(Pets pets);
	List<Pets> findByDelete(int delete);
	void deleteById(int id);
	Pets findById(int id);
	List<Pets> search(String search);
	long countDeletedPets();
	List<Pets> getActivePets();  
}
