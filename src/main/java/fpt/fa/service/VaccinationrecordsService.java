package fpt.fa.service;

import java.util.List;

import fpt.fa.entity.VaccinationRecords;

public interface VaccinationrecordsService {
	void create(VaccinationRecords vaccinationRecords);
	List<VaccinationRecords> findByDelete(int delete);
	void deleteById(int id);
	VaccinationRecords findById(int id); 
	List<VaccinationRecords> search(String search);
}
