package fpt.fa.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fpt.fa.entity.Pets;
import fpt.fa.entity.VaccinationRecords;
import fpt.fa.entity.Vaccines;
import fpt.fa.entity.Veterinarians;

public interface vaccinationrecordsRepository extends JpaRepository<VaccinationRecords, Integer> {
	List<VaccinationRecords> findByDelete(int delete); 
	
	List<VaccinationRecords> findByPetIDOrVaccineIDOrVaccinationDateOrVeterinarianIDOrNextDueDateAndDelete(Pets petID, Vaccines vaccineID, Date vaccinationDate, Veterinarians veterinarianID, Date nextDueDate, int delete);
}
