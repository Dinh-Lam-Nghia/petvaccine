package fpt.fa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int positionID;

	@Column(columnDefinition = "nvarchar(250)")
	private String name;

	@OneToMany(mappedBy = "positionID")
	private List<Account> userID;

	@Column(name = "isDelete")
	private int delete;

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public Position() {
		super();
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getUserID() {
		return userID;
	}

	public void setUserID(List<Account> userID) {
		this.userID = userID;
	}

	public Position(int positionID, String name, int delete) {
		super();
		this.positionID = positionID;
		this.name = name;
		this.delete = delete;
	}
	
}
