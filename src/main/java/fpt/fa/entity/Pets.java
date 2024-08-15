package fpt.fa.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
public class Pets {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petID;

	@ManyToOne
	@JoinColumn(name = "ownerID", referencedColumnName = "ownerID")
	private PetOwners ownerID;

	@Column(columnDefinition = "nvarchar(250)")
	private String petName;

	@Column(columnDefinition = "nvarchar(250)")
	private String species;

	@Column(columnDefinition = "nvarchar(250)")
	private String breed;

	@Column(columnDefinition = "date")
	private Date dateOfBirth;

	@Column(columnDefinition = "nvarchar(250)")
	private String gender;

	@Column(columnDefinition = "nvarchar(250)")
	private String microchipID;

	@OneToMany(mappedBy = "petID")
	private List<VaccinationRecords> recordID;

	@OneToMany(mappedBy = "petID")
	private List<Appointments> appointmentID;

	@Column(name = "isDelete")
	private int delete;

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public Pets() {
		super();
	}

	public int getPetID() {
		return petID;
	}

	public void setPetID(int petID) {
		this.petID = petID;
	}

	public PetOwners getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(PetOwners ownerID) {
		this.ownerID = ownerID;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMicrochipID() {
		return microchipID;
	}

	public void setMicrochipID(String microchipID) {
		this.microchipID = microchipID;
	}

	public List<VaccinationRecords> getRecordID() {
		return recordID;
	}

	public void setRecordID(List<VaccinationRecords> recordID) {
		this.recordID = recordID;
	}

	public List<Appointments> getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(List<Appointments> appointmentID) {
		this.appointmentID = appointmentID;
	}
}
