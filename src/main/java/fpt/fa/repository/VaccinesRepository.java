package fpt.fa.repository;

import fpt.fa.entity.Vaccines;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinesRepository extends JpaRepository<Vaccines, Integer> {
	Page<Vaccines> findAllVaccinesByVaccineNameContaining(String name, Pageable pageable);
}
