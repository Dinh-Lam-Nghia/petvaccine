package fpt.fa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import fpt.fa.entity.Clinics;

public interface ClinicsRepository extends JpaRepository<Clinics, Integer> {
    
	List<Clinics> findByDelete(int delete);
	List<Clinics> searchClinicsByKeyword(String keyword);
}

