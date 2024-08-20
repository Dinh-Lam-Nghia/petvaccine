package fpt.fa.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	private Date duration;
	
	private Date receiptDate;

	@OneToMany(mappedBy = "vaccineID")
	private List<VaccinationRecords> recordID;

	@Column(name = "isDelete")
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

	public Date getDuration() {
		return duration;
	}
	
	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public Date ReceiptDate() {
		return receiptDate;
	}
	
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}
	
	public List<VaccinationRecords> getRecordID() {
		return recordID;
	}

	public void setRecordID(List<VaccinationRecords> recordID) {
		this.recordID = recordID;
	}

	public Vaccines(int vaccineID, String vaccineName, String manufacturer, String diseasePrevented, Date duration,Date receiptDate, int delete) {
		super();
		this.vaccineID = vaccineID;
		this.vaccineName = vaccineName;
		this.manufacturer = manufacturer;
		this.diseasePrevented = diseasePrevented;
		this.duration = duration;
		this.receiptDate = receiptDate;
		this.delete = delete;
	}
	
	
}
