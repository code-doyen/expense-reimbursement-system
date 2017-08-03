package com.revature.model;
import java.sql.Blob;

/* Main Customer POJO (bean) needed for example */
public class Reimbursement {
	private int id;
	private int staff_id;
	private String fullname;
	private String manager;
	private int amount;
	private int pending;
	private String description;
	private String date_submitted;
	private String date_approved;
	private String approve_by;
	private Blob image; // needs changed to image object
	private String position;
	private String status;
	private String type;
	
	public Reimbursement() {
		this.id = 0;
		this.staff_id = 0;
		this.fullname = "";
		this.manager = "";
		this.amount = 0;
		this.pending = 0;
		this.description = "";
		this.date_submitted = "";
		this.date_approved = "";
		this.approve_by = "";
		this.image = null;
		this.position = "";
		this.status = "";
		this.type = "";
	}
	public Reimbursement(int staff_id) {
		this.staff_id = staff_id;
	}
	
	public Reimbursement(String status ) {
		this.status	 = status;
	}
	
	public Reimbursement(String status, int id) {
		this.id = id;
		this.status = status;
	}
	
	public Reimbursement(int staff_id, String status) {
		this.staff_id = staff_id;
		this.status = status;
	}
	
	public Reimbursement(int staff_id, int amount, String description, Blob image, String type) {
		this.staff_id = staff_id;
		this.amount = amount;
		this.description = description;
		this.image = image;
		this.type = type;
	}
	
	public Reimbursement(int id, String requestee, int amount, int pending, String description, String date_submitted,
			String date_approved, String approve_by, String aprovee, String status, String type){
		this.id = id;
		this.fullname = requestee;
		this.amount = amount;
		this.pending = pending;
		this.description = description;
		this.date_submitted = date_submitted;
		this.date_approved = date_approved;
		this.approve_by = approve_by;
		this.manager = aprovee;
		this.status = status;
		this.type = type;
	}
			
			
	
	public Reimbursement(int id, int staff_id, int amount, int pending, String description, String date_submitted,
			String date_approved, String approve_by, Blob image, String position, String status, String type) {
		this.id = id;
		this.staff_id = staff_id;
		this.amount = amount;
		this.pending = pending;
		this.description = description;
		this.date_submitted = date_submitted;
		this.date_approved = date_approved;
		this.approve_by = approve_by;
		this.image = image;
		this.position = position;
		this.status = status;
		this.type = type;
	}
	
//	result.getInt("reimbursement_id"),
//	result.getString("reimbursement_staff_requestee"),
//	result.getInt("reimbursement_amount"),
//	result.getString("reimbursement_description"),
//	result.getString("reimbursement_date_submitted"),
//	result.getString("reimbursement_date_approved"),
//	result.getString("reimbursement_approve_by"),
//	result.getString("reimbursement_status"),
//	result.getString("reimbursement_type_description")
	public Reimbursement(int reimbursement_id, String reimbursement_staff_requestee, int reimbursement_amount,
			String reimbursement_description, String reimbursement_date_submitted, String reimbursement_date_approved, 
			String reimbursement_approve_by, String reimbursement_status, String reimbursement_type_description) {
		this.id = reimbursement_id;
		this.fullname = reimbursement_staff_requestee;
		this.amount = reimbursement_amount;
		//this.pending = pending;
		this.description = reimbursement_description;
		this.date_submitted = reimbursement_date_submitted;
		this.date_approved = reimbursement_date_approved;
		this.approve_by = reimbursement_approve_by;
		//this.image = image;
		//this.position = position;
		this.status = reimbursement_status;
		this.type = reimbursement_type_description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPending() {
		return pending;
	}
	public void setPending(int pending) {
		this.pending = pending;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate_submitted() {
		return date_submitted;
	}
	public void setDate_submitted(String date_submitted) {
		this.date_submitted = date_submitted;
	}
	public String getDate_approved() {
		return date_approved;
	}
	public void setDate_approved(String date_approved) {
		this.date_approved = date_approved;
	}
	public String getApprove_by() {
		return approve_by;
	}
	public void setApprove_by(String approve_by) {
		this.approve_by = approve_by;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", staff_id=" + staff_id + ", fullname=" + fullname + ", manager=" + manager
				+ ", amount=" + amount + ", pending=" + pending + ", description=" + description + ", date_submitted="
				+ date_submitted + ", date_approved=" + date_approved + ", approve_by=" + approve_by + ", image="
				+ image + ", position=" + position + ", status=" + status + ", type=" + type + "]";
	}
	
		
}
