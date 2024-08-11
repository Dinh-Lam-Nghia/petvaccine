package fpt.fa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany; 
import javax.persistence.OneToMany;

@Entity
public class Veterinarians {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int veterinarianID;

	@Column(columnDefinition = "nvarchar(250)")
	private String veterinarianName;

	@Column(columnDefinition = "nvarchar(250)")
	private String phoneNumber;

	@Column(columnDefinition = "nvarchar(250)")
	private String email;
	
	@ManyToMany
	@JoinColumn(name = "clinicID", referencedColumnName = "clinicID")
	private List<Clinics> clinicID;

	@OneToMany(mappedBy = "veterinarianID")
	private List<VaccinationRecords> recordID;

	@OneToMany(mappedBy = "veterinarianID")
	private List<Appointments> appointmentID;

	public Veterinarians() {
		super();
	}

	public int getVeterinarianID() {
		return veterinarianID;
	}

	public void setVeterinarianID(int veterinarianID) {
		this.veterinarianID = veterinarianID;
	}

	public String getVeterinarianName() {
		return veterinarianName;
	}

	public void setVeterinarianName(String veterinarianName) {
		this.veterinarianName = veterinarianName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Clinics> getClinicID() {
		return clinicID;
	}

	public void setClinicID(List<Clinics> clinicID) {
		this.clinicID = clinicID;
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
