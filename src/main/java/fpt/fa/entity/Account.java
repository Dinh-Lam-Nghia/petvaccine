package fpt.fa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;

	@Column(columnDefinition = "nvarchar(250)")
	private String userName;

	@Column(columnDefinition = "nvarchar(250)")
	private String userPass;

	@Column(columnDefinition = "nvarchar(250)")
	private String displayName;

	@Column(columnDefinition = "nvarchar(250)")
	private String phone;
	
	private int delete;
	
	@ManyToOne
	@JoinColumn(name = "positionID", referencedColumnName = "positionID")	
	private Position positionID;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public Account() {
		super();
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public Position getPositionID() {
		return positionID;
	}

	public void setPositionID(Position positionID) {
		this.positionID = positionID;
	}

	
}
