package com.revature.model;
import java.awt.Image;

/* Main Customer POJO (bean) needed for example */
public class Reimbursement {
	private int id;
	private int staff_id;
	private int amount;
	private int pending;
	private String description;
	private String date_submitted;
	private String date_approved;
	private String approve_by;
	private String position;
	private String image; // needs changed to image object
	private int number
	create table reimbursement(
		    reimbursement_id number not null,--pk
		    reimbursement_staff_id number not null,
		    reimbursement_amount number not null,
		    reimbursement_pending number not null, --fk?number
		    reimbursement_description varchar2(100) not null,
		    reimbursement_date_submitted date not null,
		    reimbursement_date_approved date,  --approval date can be blank 
		    reimbursement_approve_by number, --fk 
		    reimbursement_image blob, --image can be blank
		    reimbursement_type number not null, --fk
    create table reimbursement_status(
    	    reimbursement_status_id number not null,
    	    reimbursement_status_desc varchar2(50),
    	    constraint reimbursement_status_id_pk primary key(reimbursement_status_id)
    	);

	create table reimbursement_type(
	    reimbursement_type_id number not null,
	    reimbursement_type_description varchar2(100),
	    constraint reimbursement_type_id_pk primary key(reimbursement_type_id)
	);

	//staff_id, staff_username, staff_password, staff_rank, staff_first_name, staff_last_name, staff_phone, staff_email, rank_description
	public Reimbursement() {
		this.id =0;
		this.username = "";
		this.password = "";
		this.rank = 0;
		this.firstName = "";
		this.lastName = "";
		this.phone = "";
		this.email = "";
		this.position = "";
	}

	public Reimbursement(int id) {
		this();
		this.id = id;
	}
	
	public Reimbursement(String username, String password) {
		this();
		this.username = username;
		this.password = password;
	}
	//staff_username varchar2, password varchar2, staff_rank number, staff_first_name varchar2, staff_last_name varchar2, staff_phone varchar2, staff_email varchar2, staff_position varchar2
	public Reimbursement(int id, String username, String password, int rank, String firstName, String lastName, String phone, String email, String position) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.rank = rank;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.position = position;
	}
	
	public Reimbursement(String username, String password, int rank, String firstName, String lastName, String phone, String email, String position) {
		this.username = username;
		this.password = password;
		this.rank = rank;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.position = position;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", username=" + username + ", password=" + password + ", rank=" + rank
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email
				+ ", position=" + position + "]";
	}

	
}
