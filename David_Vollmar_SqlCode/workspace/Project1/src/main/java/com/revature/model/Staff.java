package com.revature.model;

/* Main Customer POJO (bean) needed for example */
public class Staff {
	private int id;
	private String username;
	private String password;
	private int rank;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String position;
	private String fullname;
	//staff_id, staff_username, staff_password, staff_rank, staff_first_name, staff_last_name, staff_phone, staff_email, rank_description
	public Staff() {
		this.id =0;
		this.username = "";
		this.password = "";
		this.rank = 0;
		this.firstName = "";
		this.lastName = "";
		this.phone = "";
		this.email = "";
		this.position = "";
		this.fullname = "";
	}

	public Staff(int id) {
		this();
		this.id = id;
	}
	
	public Staff(String user) {
		this.username = user;
	}
	
	public Staff(String username, String password) {
		this();
		this.username = username;
		this.password = password;
	}
	
	public Staff(String member, String phone, String email) {
		this.fullname = member;
		this.phone = phone;
		this.email = email;
	}

	public Staff(String username, String password, String firstName, String lastName, String phone, String email) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}
	
	public Staff(String username, String password, String firstName, String lastName, String phone, String email, String position) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.position = position;
	}
	
	//staff_username varchar2, password varchar2, staff_rank number, staff_first_name varchar2, staff_last_name varchar2, staff_phone varchar2, staff_email varchar2, staff_position varchar2
	public Staff(int id, String username, String password, int rank, String firstName, String lastName, String phone, String email, String position) {
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
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", username=" + username + ", password=" + password + ", rank=" + rank
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email
				+ ", position=" + position + ", fullname=" + fullname + "]";
	}

	
	

	
}
