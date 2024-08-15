package fpt.fa.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PetOwners {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerID;

	@Column(columnDefinition = "nvarchar(250)")
	private String ownerName;

	@Column(columnDefinition = "nvarchar(250)")
	private String phoneNumber;

	@Column(columnDefinition = "nvarchar(250)")
	private String email;

	@Column(columnDefinition = "nvarchar(250)")
	private String address;

	@Column(columnDefinition = "date")
	private Date dateOfRegistration;

	@OneToMany(mappedBy = "ownerID")
	private List<Pets> pets;

	@OneToMany(mappedBy = "ownerID")
	private List<Appointments> appointmentID;

	private int delete;

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public PetOwners() {
		super();
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public List<Pets> getPets() {
		return pets;
	}

	public void setPets(List<Pets> pets) {
		this.pets = pets;
	}

	public List<Appointments> getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(List<Appointments> appointmentID) {
		this.appointmentID = appointmentID;
	}

}
