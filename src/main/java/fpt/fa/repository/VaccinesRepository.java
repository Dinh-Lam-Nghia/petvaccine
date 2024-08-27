package fpt.fa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.fa.entity.Vaccines;

@Repository
public interface VaccinesRepository extends JpaRepository<Vaccines, Integer> {
	Page<Vaccines> findAllVaccinesByVaccineNameContaining(String name, Pageable pageable);
	long countByDelete(int delete);
	
	List<Vaccines> findByDelete(int delete);
	
	Vaccines findByVaccineName(String vaccineName);

}
