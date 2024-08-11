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
public class Appointments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentID;
	
	@ManyToOne
	@JoinColumn(name = "petID", referencedColumnName = "petID")
	private Pets petID;

	@ManyToOne
	@JoinColumn(name = "ownerID", referencedColumnName = "ownerID")
	private PetOwners ownerID;

	@ManyToOne
	@JoinColumn(name = "veterinarianID", referencedColumnName = "veterinarianID")
	private Veterinarians veterinarianID;

	@ManyToOne
	@JoinColumn(name = "clinicID", referencedColumnName = "clinicID")
	private Clinics clinicID;

	@Column(columnDefinition = "date")
	private Date appointmentDate;

	@Column(columnDefinition = "nvarchar(250)")
	private String purpose;

	public Appointments() {
		super();
	}

	public int getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	public Pets getPetID() {
		return petID;
	}

	public void setPetID(Pets petID) {
		this.petID = petID;
	}

	public PetOwners getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(PetOwners ownerID) {
		this.ownerID = ownerID;
	}

	public Veterinarians getVeterinarianID() {
		return veterinarianID;
	}

	public void setVeterinarianID(Veterinarians veterinarianID) {
		this.veterinarianID = veterinarianID;
	}

	public Clinics getClinicID() {
		return clinicID;
	}

	public void setClinicID(Clinics clinicID) {
		this.clinicID = clinicID;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
}
