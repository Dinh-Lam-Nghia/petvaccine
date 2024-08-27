package fpt.fa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fpt.fa.entity.Vaccines;

public interface VaccinesService {
	void create(Vaccines vaccines);
	void delete(int id);
	void deleteById(int id);
	void update(Vaccines vaccines);
	Vaccines findById(int vaccineID);
	List<Vaccines> getListVaccines();
	Page<Vaccines> getListVaccinesWithPaging(Pageable pageable);
	Page<Vaccines> findVaccinesByName(String name, Pageable pageable);
	long countAllVaccines();
	long countDeletedVaccines();
	List<Vaccines> findByDelete(int delete);
}
