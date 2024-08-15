package fpt.fa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vaccines {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vaccineID;

	@Column(columnDefinition = "nvarchar(250)")
	private String vaccineName;

	@Column(columnDefinition = "nvarchar(250)")
	private String manufacturer;

	@Column(columnDefinition = "nvarchar(250)")
	private String diseasePrevented;

	private int duration;

	@OneToMany(mappedBy = "vaccineID")
	private List<VaccinationRecords> recordID;

	private int delete;

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public Vaccines() {
		super();
	}

	public int getVaccineID() {
		return vaccineID;
	}

	public void setVaccineID(int vaccineID) {
		this.vaccineID = vaccineID;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDiseasePrevented() {
		return diseasePrevented;
	}

	public void setDiseasePrevented(String diseasePrevented) {
		this.diseasePrevented = diseasePrevented;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<VaccinationRecords> getRecordID() {
		return recordID;
	}

	public void setRecordID(List<VaccinationRecords> recordID) {
		this.recordID = recordID;
	}
}
