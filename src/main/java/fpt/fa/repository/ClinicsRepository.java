package fpt.fa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fpt.fa.entity.Clinics;

@Repository
public interface ClinicsRepository extends JpaRepository<Clinics, Integer> {
    // You can define custom query methods here if needed
	List<Clinics> findByDelete(int delete);
}
