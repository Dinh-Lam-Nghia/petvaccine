package fpt.fa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Clinics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clinicID;

	@Column(columnDefinition = "nvarchar(250)")
	private String clinicName;

	@Column(columnDefinition = "nvarchar(250)")
	private String address;

	@Column(columnDefinition = "nvarchar(250)")
	private String phoneNumber;

	@ManyToMany(mappedBy = "clinicID")
	private List<Veterinarians> veterinarianID;

	@ManyToMany(mappedBy = "clinicID")
	private List<Appointments> appointmentID;

	private int delete;

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public Clinics() {
		super();
	}

	public int getClinicID() {
		return clinicID;
	}

	public void setClinicID(int clinicID) {
		this.clinicID = clinicID;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Veterinarians> getVeterinarianID() {
		return veterinarianID;
	}

	public void setVeterinarianID(List<Veterinarians> veterinarianID) {
		this.veterinarianID = veterinarianID;
	}

	public List<Appointments> getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(List<Appointments> appointmentID) {
		this.appointmentID = appointmentID;
	}
}
