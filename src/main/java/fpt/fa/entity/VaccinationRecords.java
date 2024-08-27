package fpt.fa.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class VaccinationRecords {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recordID;

	@ManyToOne
	@JoinColumn(name = "petID", referencedColumnName = "petID")
	private Pets petID;

	@ManyToOne
	@JoinColumn(name = "vaccineID", referencedColumnName = "vaccineID")
	private Vaccines vaccineID;

	@Column(columnDefinition = "date")
	private Date vaccinationDate;

	@ManyToOne
	@JoinColumn(name = "veterinarianID", referencedColumnName = "veterinarianID")
	private Veterinarians veterinarianID;

	@Column(columnDefinition = "date")
	private Date nextDueDate;

	@Column(name = "isDelete")
	private int delete;

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public VaccinationRecords() {
		super();
	}

	public int getRecordID() {
		return recordID;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public Pets getPetID() {
		return petID;
	}

	public void setPetID(Pets petID) {
		this.petID = petID;
	}

	public Vaccines getVaccineID() {
		return vaccineID;
	}

	public void setVaccineID(Vaccines vaccineID) {
		this.vaccineID = vaccineID;
	}

	public Date getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public Veterinarians getVeterinarianID() {
		return veterinarianID;
	}

	public void setVeterinarianID(Veterinarians veterinarianID) {
		this.veterinarianID = veterinarianID;
	}

	public Date getNextDueDate() {
		return nextDueDate;
	}

	public void setNextDueDate(Date nextDueDate) {
		this.nextDueDate = nextDueDate;
	}

}
