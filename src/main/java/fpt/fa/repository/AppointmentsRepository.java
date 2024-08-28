package fpt.fa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fpt.fa.entity.Appointments;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments, Integer> {
	List<Appointments> findByDelete(int delete);
	long countByDelete(int delete);
}
